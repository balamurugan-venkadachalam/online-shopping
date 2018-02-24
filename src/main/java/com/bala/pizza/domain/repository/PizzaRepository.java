package com.bala.pizza.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bala.pizza.domain.model.Pizza;

public interface PizzaRepository  extends JpaRepository<Pizza, Integer> {

}
