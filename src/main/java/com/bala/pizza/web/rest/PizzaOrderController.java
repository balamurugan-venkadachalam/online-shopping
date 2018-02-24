package com.bala.pizza.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bala.pizza.domain.model.PizzaOrder;
import com.bala.pizza.service.PizzaOrderService;

@RestController
public class PizzaOrderController {
	
	@Autowired
	PizzaOrderService pizzaOrderService;
	
	@PostMapping("/pizza/order")
	public @ResponseBody PizzaOrder order(@RequestBody PizzaOrder onlineOrder) {
		onlineOrder = pizzaOrderService.saveOrder(onlineOrder);
		return onlineOrder;
	}

}
