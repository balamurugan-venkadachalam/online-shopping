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

		PizzaLineItem pizzaLineItem = new PizzaLineItem();
		pizzaLineItem.setCrust(new Crust(10));
		pizzaLineItem.setPizza(new Pizza(1001));
		pizzaLineItem.setPizzaSize(new PizzaSize(3));
		pizzaLineItem.setPizzaOrderId(10001);
		pizzaLineItem.setPizzaOrder(order);
		order.getPizzaLineItemCollection().add(pizzaLineItem);

		PizzaTopping pizzaTopping= new PizzaTopping(1);
		pizzaTopping.setToppingId(new Tooping(110));		
		pizzaTopping.setPizzaLineItem(pizzaLineItem);
		pizzaLineItem.getPizzaToppingCollection().add(pizzaTopping);	
		
		return order;
	}
}
