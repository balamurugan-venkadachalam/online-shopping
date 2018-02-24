package com.bala.pizza.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bala.pizza.service.PizzaDeliveryService;

@RestController
public class PizzaDeliveryController {
	
	@Autowired
	private PizzaDeliveryService pizzaDeliveryService;
	
	
	

}
