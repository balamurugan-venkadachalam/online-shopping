package com.bala.pizza.builder;

import org.springframework.beans.factory.annotation.Autowired;

import com.bala.pizza.domain.model.Crust;
import com.bala.pizza.domain.model.Pizza;
import com.bala.pizza.domain.model.PizzaLineItem;
import com.bala.pizza.domain.model.PizzaOrder;
import com.bala.pizza.domain.model.PizzaSize;
import com.bala.pizza.domain.model.PizzaTopping;
import com.bala.pizza.domain.model.Tooping;
import com.bala.pizza.domain.repository.CrustRepository;
import com.bala.pizza.domain.repository.PizzaRepository;
import com.bala.pizza.domain.repository.PizzaSizeRepository;
import com.bala.pizza.domain.repository.ToopingRepository;

public class LineItemBuilder {
	
	@Autowired
	private PizzaRepository pizzaRepository;
	
	@Autowired 
	private PizzaSizeRepository pizzaSizeRepository;
	
	@Autowired
	private ToopingRepository toopingRepository;
	
	@Autowired
	private CrustRepository crustRepository;
	
	PizzaLineItem lineItem = new PizzaLineItem();
	
	public LineItemBuilder withCrust(int crustId){
		Crust crust = crustRepository.getOne(crustId);
		lineItem.setCrust(crust);
		lineItem.addPrice(crust.getCustPrice());
		return this;
	} 
	
	public LineItemBuilder withPizza(int pizzaId){
		 Pizza pizza = pizzaRepository.getOne(pizzaId);
		lineItem.setPizza(pizza);
		lineItem.addPrice(pizza.getPizzaPrice());		
		return this;
	} 
	
	public LineItemBuilder withTopping(int[] toppingIds){
		for (int toppingId : toppingIds) {
			Tooping tooping = toopingRepository.getOne(toppingId);
			lineItem.addPrice(tooping.getToopingPrice());
			lineItem.getPizzaToppingCollection().add(new PizzaTopping(lineItem, tooping));
		}		
		return this;
	} 
	
	public LineItemBuilder withSize(int sizeId){
		PizzaSize pizzaSize = pizzaSizeRepository.getOne(sizeId);
		lineItem.setPizzaSize(pizzaSize);
		lineItem.addPrice(pizzaSize.getPizzaSizePrice());
		return this;
	}
	
    public PizzaLineItem build() {
        return lineItem;
    }

}
