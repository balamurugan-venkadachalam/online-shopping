package com.bala.pizza.builder;

import org.springframework.beans.factory.annotation.Autowired;

import com.bala.pizza.domain.model.Crust;
import com.bala.pizza.domain.model.PizzaOrder;
import com.bala.pizza.domain.model.PizzaLineItem;
import com.bala.pizza.domain.model.PizzaSize;
import com.bala.pizza.domain.model.PizzaTopping;
import com.bala.pizza.domain.model.Tooping;
import com.bala.pizza.domain.repository.CrustRepository;
import com.bala.pizza.domain.repository.PizzaRepository;
import com.bala.pizza.domain.repository.PizzaSizeRepository;
import com.bala.pizza.domain.repository.ToopingRepository;

public class OrderBuilder {
	@Autowired
	private PizzaRepository pizzaRepository;
	
	@Autowired 
	private PizzaSizeRepository pizzaSizeRepository;
	
	@Autowired
	private ToopingRepository toopingRepository;
	
	@Autowired
	private CrustRepository crustRepository;
	
	PizzaOrder order = new PizzaOrder();
	
	PizzaLineItem lineItem = new PizzaLineItem();
	
	public OrderBuilder withOrder(PizzaOrder order){
		this.order.setCustomerName(order.getCustomerName());
		this.order.setCustomerAddress(order.getCustomerAddress());
		this.order.setCustomerContact(order.getCustomerContact());
		this.order.setDeliveryNote(order.getDeliveryNote());
		this.order.setTotalAmount(order.getTotalAmount());
		this.order.getPizzaOrderCollection().add(lineItem);
		return this;
	} 

	public OrderBuilder withCrust(int crustId){
		Crust crust = crustRepository.getOne(crustId);
		lineItem.setCrustId(crust);
		lineItem.addPrice(crust.getCustPrice());
		return this;
	} 
	
	public OrderBuilder withTopping(int[] toppingIds){
		for (int toppingId : toppingIds) {
			Tooping tooping = toopingRepository.getOne(toppingId);
			lineItem.addPrice(tooping.getToopingPrice());
			lineItem.getPizzaToppingCollection().add(new PizzaTopping(lineItem, tooping));
		}		
		return this;
	} 
	
	public OrderBuilder withSize(int sizeId){
		PizzaSize pizzaSize = pizzaSizeRepository.getOne(sizeId);
		lineItem.setPizzaSizeId(pizzaSize);
		lineItem.addPrice(pizzaSize.getPizzaSizePrice());
		return this;
	}
	
	
	
}
