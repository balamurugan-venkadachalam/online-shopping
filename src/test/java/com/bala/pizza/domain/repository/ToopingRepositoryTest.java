package com.bala.pizza.domain.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bala.pizza.PizzaServiceApplication;
import com.bala.pizza.domain.model.Tooping;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PizzaServiceApplication.class)
public class ToopingRepositoryTest {

    
    @Autowired
    private ToopingRepository toopingRepository;
    
    @Test
    public void fetch_all_toopings(){
    	List<Tooping> toopings =  toopingRepository.findAll();
    	Assert.assertFalse(toopings.isEmpty());
    }
}
