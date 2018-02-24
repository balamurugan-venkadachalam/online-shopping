package com.bala.pizza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bala.pizza.domain.model.OnlineOrder;
import com.bala.pizza.domain.repository.OnlineOrderRepository;

@Service
public class PizzaDeliveryServiceImpl implements PizzaDeliveryService{
	
	@Autowired
	private OnlineOrderRepository onlineOrderRepository;

	@Override
	public List<OnlineOrder> fetchDeliverys() {
		return onlineOrderRepository.findAll();
	}

	@Override
	public void deleteDelivery(int id) {
		onlineOrderRepository.deleteById(id);		
	}

}
