package com.bala.pizza.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bala.pizza.domain.model.PizzaTopping;


public interface PizzaToopingRepository extends JpaRepository<PizzaTopping, Integer>{

}
