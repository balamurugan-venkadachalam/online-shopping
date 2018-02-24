package com.bala.pizza.service;

import java.util.List;

import com.bala.pizza.domain.model.PizzaOrder;

public interface PizzaDeliveryService {

	public List<PizzaOrder> fetchOrders();
	
	public void deleteDelivery(long orderid);
	
	
}
