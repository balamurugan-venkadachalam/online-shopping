package com.bala.pizza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bala.pizza.domain.model.PizzaOrder;
import com.bala.pizza.domain.repository.OnlineOrderRepository;

@Service
public class PizzaOrderServiceImpl implements PizzaOrderService{

	@Autowired
	private OnlineOrderRepository onlineOrderRepository;
	
	@Override
	public PizzaOrder saveOrder(PizzaOrder onlineOrder) {
		 PizzaOrder order = onlineOrderRepository.save(onlineOrder);
		 return order;
	}

	@Override
	public PizzaOrder fetchOrder(Long orderId) {
		return onlineOrderRepository.getOne(orderId);
	}
	
}
