package com.bala.pizza.service;

import java.util.List;

import com.bala.pizza.domain.model.Crust;
import com.bala.pizza.domain.model.Pizza;
import com.bala.pizza.domain.model.PizzaSize;
import com.bala.pizza.domain.model.Tooping;

public interface PizzaService {

	public List<Pizza> getPizzas();

	public List<PizzaSize> getPizzaSizes();

	public List<Tooping> getToopings();

	public List<Crust> getCrusts();

	public Pizza getPizza(int pizzId);

	public PizzaSize getPizzaSize(int pizzaSizeId);

	public Tooping getTooping(int toopingId);

	public Crust getCrust(int crustId);

}
