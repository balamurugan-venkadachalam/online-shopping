package com.bala.pizza.service;

import com.bala.pizza.domain.model.PizzaOrder;

public interface PizzaOrderService {
	
	public PizzaOrder saveOrder(PizzaOrder onlineOrder);
	
	public PizzaOrder fetchOrder(Long orderId);

}
