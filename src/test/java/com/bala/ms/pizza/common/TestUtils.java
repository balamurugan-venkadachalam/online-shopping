package com.bala.ms.pizza.common;

import com.bala.pizza.domain.model.Crust;
import com.bala.pizza.domain.model.PizzaOrder;
import com.bala.pizza.domain.model.Pizza;
import com.bala.pizza.domain.model.PizzaLineItem;
import com.bala.pizza.domain.model.PizzaSize;
import com.bala.pizza.domain.model.PizzaTopping;
import com.bala.pizza.domain.model.Tooping;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtils {
	
	private static ObjectMapper mapper = new ObjectMapper();

	public static void main(String[] args) throws JsonProcessingException {
		System.out.println(mapper.writeValueAsString(generateDummyOrderObject() ));
	}

	public static PizzaOrder generateDummyOrderObject() {
		
		PizzaOrder order= new PizzaOrder();
		order.setOrderId(1001l);
		order.setCustomerAddress("Address 1");
		order.setCustomerName("Customer name");
		order.setCustomerContact("+64 11 452 3625");

		PizzaLineItem pizzaOrder = new PizzaLineItem();
		pizzaOrder.setCrustId(new Crust(10));
		pizzaOrder.setPizzaId(new Pizza(1001));
		pizzaOrder.setPizzaSizeId(new PizzaSize(3));
		pizzaOrder.setPizzaOrderId(10001);
		pizzaOrder.setOrderId(order);
		order.getPizzaOrderCollection().add(pizzaOrder);

		PizzaTopping pizzaTopping= new PizzaTopping(1);
		pizzaTopping.setToppingId(new Tooping(110));		
		pizzaTopping.setPizzaOrderId(pizzaOrder);
		pizzaOrder.getPizzaToppingCollection().add(pizzaTopping);	
		
		return order;
	}
}
