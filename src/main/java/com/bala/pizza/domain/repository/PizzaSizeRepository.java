package com.bala.pizza.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bala.pizza.domain.model.PizzaSize;


public interface PizzaSizeRepository extends JpaRepository<PizzaSize, Integer>{

}
