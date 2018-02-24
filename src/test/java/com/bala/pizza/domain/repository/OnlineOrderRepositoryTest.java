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

import com.bala.ms.pizza.common.TestUtils;
import com.bala.pizza.PizzaServiceApplication;
import com.bala.pizza.domain.model.PizzaOrder;
import com.bala.pizza.domain.model.Tooping;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PizzaServiceApplication.class)
public class OnlineOrderRepositoryTest {

    
    @Autowired
    private OnlineOrderRepository onlineOrderRepository;
    
    @Test
    public void save_order_with_valid_input(){
    	PizzaOrder onlineOrder = onlineOrderRepository.save(TestUtils.generateDummyOrderObject());
    	Assert.assertEquals(true, onlineOrder.getOrderId()!=null);
    }
}
