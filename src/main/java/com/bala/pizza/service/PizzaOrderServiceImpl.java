package com.bala.pizza.service;

import java.util.ArrayList;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bala.pizza.domain.model.PizzaOrder;
import com.bala.pizza.domain.model.PizzaLineItem;
import com.bala.pizza.domain.repository.OnlineOrderRepository;
import com.bala.pizza.domain.repository.PizzaOrderRepository;
import com.bala.pizza.domain.repository.PizzaToopingRepository;

@Service
public class PizzaOrderServiceImpl implements PizzaOrderService{

	@Autowired
	private OnlineOrderRepository onlineOrderRepository;
	
	@Override
	public PizzaOrder saveOrder(PizzaOrder onlineOrder) {
		 PizzaOrder order = onlineOrderRepository.save(onlineOrder);
		 return order;
	}
	
}
