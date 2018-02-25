package com.bala.pizza.web.rest;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bala.pizza.common.Constants;
import com.bala.pizza.domain.model.PizzaOrder;
import com.bala.pizza.exception.OrderNotCreatedException;
import com.bala.pizza.service.PizzaOrderService;

@RestController
public class PizzaOrderController {
	
	

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PizzaOrderService pizzaOrderService;
	
	@PutMapping("/pizza/order")
	public @ResponseBody Resource<PizzaOrder>  order(@Valid @RequestBody PizzaOrder order) {
		logger.info("pizza order input {}", order);
		
		
				
		PizzaOrder pizzaOrder = pizzaOrderService.saveOrder(order);
		if(pizzaOrder == null){
			throw new OrderNotCreatedException(Constants.SOMETHING_FISHY_ORDER_NOT_CREATED);
		}
		
		logger.info("pizza order response {}", pizzaOrder);		
		return attachResourceUri(pizzaOrder);
	}


	
	@GetMapping("/pizza/order/{orderId}")
	public @ResponseBody PizzaOrder getOrder(Long orderId){
		return pizzaOrderService.fetchOrder(orderId);
		
	}
	
	
	private Resource<PizzaOrder> attachResourceUri(PizzaOrder pizzaOrder) {
		Resource<PizzaOrder> resource = new Resource<PizzaOrder>(pizzaOrder);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getOrder(pizzaOrder.getOrderId()));
		resource.add(linkTo.withRel("Order"));
		return resource;
	}

}
