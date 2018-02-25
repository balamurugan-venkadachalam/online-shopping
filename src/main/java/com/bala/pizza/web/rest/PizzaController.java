package com.bala.pizza.web.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bala.pizza.domain.model.Crust;
import com.bala.pizza.domain.model.Pizza;
import com.bala.pizza.domain.model.PizzaSize;
import com.bala.pizza.domain.model.Tooping;
import com.bala.pizza.service.PizzaService;

/**
 * This class provide pizza menu service for customize pizza order
 * @author engan.bala
 *
 */
@RestController
public class PizzaController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PizzaService pizzaService;
	

	/**
	 * This method is used to load all type of pizza
	 * @return pizza list
	 */
	@GetMapping("/pizzas")
	public List<Pizza> getPizzas(){
		return pizzaService.getPizzas();
	}
	
	/**
	 * This method is used to load all pizza size
	 * @return pizza size list
	 */
	@GetMapping("/pizza/sizes")
	public List<PizzaSize> getPizzaSizes(){
		return pizzaService.getPizzaSizes();				
	}
	
	/**
	 * This method is used to load all type of pizza toopings
	 * @return pizza tooping list
	 */
	@GetMapping("/pizza/toopings")
	public List<Tooping> getPizzaToopings(){
		return pizzaService.getToopings();				
	}
	
	/**
	 * This method is used to load all type of pizza crusts
	 * @return pizza crusts list
	 */
	@GetMapping("/pizza/crusts")
	public List<Crust> getPizzaCrusts(){
		return pizzaService.getCrusts();
	}
	
}
