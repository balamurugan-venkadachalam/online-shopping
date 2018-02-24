package com.bala.pizza.common;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bala.pizza.domain.model.Crust;
import com.bala.pizza.domain.model.Pizza;
import com.bala.pizza.domain.model.PizzaSize;
import com.bala.pizza.domain.model.PizzaTopping;
import com.bala.pizza.domain.repository.CrustRepository;
import com.bala.pizza.domain.repository.PizzaRepository;
import com.bala.pizza.domain.repository.PizzaSizeRepository;
import com.bala.pizza.domain.repository.PizzaToopingRepository;;

@Component
public class CommomConstants {
	
	@Autowired
	private PizzaRepository pizzaRepository;
	
	@Autowired 
	private PizzaSizeRepository pizzaSizeRepository;
	
	@Autowired
	private PizzaToopingRepository pizzaToopingRepository;
	
	@Autowired
	private CrustRepository crustRepository;
	
	public static Map<Integer, Pizza> pizzas = new HashMap<Integer, Pizza>();
	
	public static Map<Integer, PizzaSize> pizzaSizes = new HashMap<Integer, PizzaSize>();
	
	public static Map<Integer, PizzaTopping> pizzaToppings = new HashMap<Integer, PizzaTopping>();
	
	public static Map<Integer, Crust> crust = new HashMap<Integer, Crust>();
	

 
	
	

}
