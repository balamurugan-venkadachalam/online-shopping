package com.bala.pizza.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bala.pizza.domain.model.PizzaLineItem;

public interface PizzaOrderRepository  extends JpaRepository<PizzaLineItem, Integer> {

}
