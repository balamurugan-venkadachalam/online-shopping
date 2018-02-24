package com.bala.pizza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bala.pizza.domain.model.Crust;
import com.bala.pizza.domain.model.Pizza;
import com.bala.pizza.domain.model.PizzaSize;
import com.bala.pizza.domain.model.Tooping;
import com.bala.pizza.domain.repository.CrustRepository;
import com.bala.pizza.domain.repository.PizzaRepository;
import com.bala.pizza.domain.repository.PizzaSizeRepository;
import com.bala.pizza.domain.repository.ToopingRepository;

/**
 * 
 * @author engan.bala
 *
 */
@Service
public class PizzaServiceImpl implements PizzaService{
	
	@Autowired
	private PizzaRepository pizzaRepository;
	
	@Autowired
	private PizzaSizeRepository pizzaSizeRepository;
	
	@Autowired
	private ToopingRepository toopingRepository;
	
	@Autowired
	private CrustRepository crustRepository;
	

	@Override
	public List<Pizza> getPizzas() {		
		return pizzaRepository.findAll();
	}

	@Override
	public List<PizzaSize> getPizzaSizes() {		
		return pizzaSizeRepository.findAll();
	}

	@Override
	public List<Tooping> getToopings() {
		return toopingRepository.findAll();
	}

	@Override
	public List<Crust> getCrusts() {
		return crustRepository.findAll();
	}

	@Override
	public Pizza getPizza(int pizzId) {
		return pizzaRepository.getOne(pizzId);
	}

	@Override
	public PizzaSize getPizzaSize(int pizzaSizeId) {
		return pizzaSizeRepository.getOne(pizzaSizeId);
	}

	@Override
	public Tooping getTooping(int toopingId) {
		return toopingRepository.getOne(toopingId);
	}

	@Override
	public Crust getCrust(int crustId) {
		return crustRepository.getOne(crustId);
	}
	

}
