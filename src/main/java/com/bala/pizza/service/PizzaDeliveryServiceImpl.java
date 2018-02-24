package com.bala.pizza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bala.pizza.domain.model.PizzaOrder;
import com.bala.pizza.domain.repository.OnlineOrderRepository;

@Service
public class PizzaDeliveryServiceImpl implements PizzaDeliveryService{
	
	@Autowired
	private OnlineOrderRepository onlineOrderRepository;

	@Override
	public List<PizzaOrder> fetchOrders() {
		return onlineOrderRepository.findAll();
	}

	@Override
	public void deleteDelivery(long orderid) {
		onlineOrderRepository.deleteById(orderid);		
	}

}
