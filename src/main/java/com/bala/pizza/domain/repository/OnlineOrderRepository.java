package com.bala.pizza.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bala.pizza.domain.model.OnlineOrder;


public interface OnlineOrderRepository extends JpaRepository<OnlineOrder, Integer>{

}
