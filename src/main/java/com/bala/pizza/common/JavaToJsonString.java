package com.bala.pizza.common;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;

import com.bala.pizza.domain.model.Crust;
import com.bala.pizza.domain.model.OnlineOrder;
import com.bala.pizza.domain.model.Pizza;
import com.bala.pizza.domain.model.PizzaOrder;
import com.bala.pizza.domain.model.PizzaSize;
import com.bala.pizza.domain.model.PizzaTopping;
import com.bala.pizza.domain.model.Tooping;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JavaToJsonString {

	public static void main(String[] args) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(generateDummyObject() ));
	}

	private static OnlineOrder generateDummyObject() {
		PizzaTopping pizzaTopping= new PizzaTopping(101);
		pizzaTopping.setToppingId(new Tooping(11));
		
		List<PizzaTopping> pissaToppings = new ArrayList<>();
		pissaToppings.add(pizzaTopping);
		
		PizzaOrder pizzaOrder = new PizzaOrder();
		pizzaOrder.setCrustId(new Crust(11));
		pizzaOrder.setPizzaId(new Pizza(111));
		pizzaOrder.setPizzaSizeId(new PizzaSize(11));
		pizzaOrder.setPizzaOrderId(101);
		//pizzaOrder.setPizzaToppingCollection(pissaToppings );
		pizzaTopping.setPizzaOrderId(pizzaOrder);

		List<PizzaOrder> pizzaOrders = new ArrayList<>();
		pizzaOrders.add(pizzaOrder);
		OnlineOrder order= new OnlineOrder();
		order.setOrderId(101l);
		order.setCustomerAddress("Address 1");
		order.setCustomerName("Customer name");
		
		order.setPizzaOrderCollection(pizzaOrders);
		return order;
	}
}
