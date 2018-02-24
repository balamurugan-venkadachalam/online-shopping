package com.bala.pizza.web.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bala.pizza.domain.model.PizzaOrder;
import com.bala.pizza.service.PizzaDeliveryService;

@RestController
public class PizzaDeliveryController {
	
	@Autowired
	private PizzaDeliveryService pizzaDeliveryService;
	
	@DeleteMapping("/pizza/order/{orderid}/delivered")
	public void markDelivered(@PathParam(value="id") Long orderid){
		pizzaDeliveryService.deleteDelivery(orderid);
	}
	
	@GetMapping("/pizza/delivery/orders")
	public @ResponseBody List<PizzaOrder> getOrders(){
		return pizzaDeliveryService.fetchOrders();
	}
	
	
	

}
