package com.bala.pizza.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bala.ms.pizza.common.TestUtils;
import com.bala.pizza.PizzaServiceApplication;
import com.bala.pizza.domain.model.PizzaOrder;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PizzaServiceApplication.class)
public class PizzaOrderServiceTest {
	
	@Autowired
	private PizzaOrderService orderService;
	
    @Test
    public void save_order_with_valid_input(){
    	 orderService.saveOrder(TestUtils.generateDummyOrderObject());
    	//Assert.assertEquals(true, onlineOrder.getOrderId()!=null);
    }

}
