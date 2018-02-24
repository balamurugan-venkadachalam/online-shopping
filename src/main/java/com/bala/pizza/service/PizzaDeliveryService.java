package com.bala.pizza.service;

import java.util.List;

import com.bala.pizza.domain.model.OnlineOrder;

public interface PizzaDeliveryService {

	public List<OnlineOrder> fetchDeliverys();
	
	public void deleteDelivery(int id);
	
	
}
