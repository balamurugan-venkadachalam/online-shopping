package com.bala.pizza.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bala.pizza.domain.model.PizzaOrder;

public interface PizzaOrderRepository  extends JpaRepository<PizzaOrder, Integer> {

}
