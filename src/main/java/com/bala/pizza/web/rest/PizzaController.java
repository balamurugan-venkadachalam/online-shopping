package com.bala.pizza.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bala.pizza.domain.model.Crust;
import com.bala.pizza.domain.model.Pizza;
import com.bala.pizza.domain.model.PizzaSize;
import com.bala.pizza.domain.model.Tooping;
import com.bala.pizza.service.PizzaService;

/**
 * 
 * @author engan.bala
 *
 */
@RestController
public class PizzaController {
	
	@Autowired
	private PizzaService pizzaService;
	


	@GetMapping("/pizzas")
	public List<Pizza> getPizzas(){
		return pizzaService.getPizzas();
	}
	
	@GetMapping("/pizza/sizes")
	public List<PizzaSize> getPizzaSizes(){
		return pizzaService.getPizzaSizes();				
	}
	
	@GetMapping("/pizza/toopings")
	public List<Tooping> getPizzaToopings(){
		return pizzaService.getToopings();				
	}
	
	
	@GetMapping("/pizza/crusts")
	public List<Crust> getPizzaCrusts(){
		return pizzaService.getCrusts();
	}
	
}
