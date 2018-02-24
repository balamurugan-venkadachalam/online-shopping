package com.bala.pizza.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bala.pizza.domain.model.Crust;


public interface CrustRepository extends JpaRepository<Crust, Integer>{

}
