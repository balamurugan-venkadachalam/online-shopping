package com.bala.pizza.builder;

import com.bala.pizza.domain.model.PizzaLineItem;
import com.bala.pizza.domain.model.PizzaOrder;


public class PizzaOrderBuilder {

	PizzaOrder pizzaOrder = new PizzaOrder();

	public PizzaOrderBuilder withOrder(PizzaOrder order) {
		this.pizzaOrder.setCustomerName(order.getCustomerName());
		this.pizzaOrder.setCustomerAddress(order.getCustomerAddress());
		this.pizzaOrder.setCustomerContact(order.getCustomerContact());
		this.pizzaOrder.setDeliveryNote(order.getDeliveryNote());
		this.pizzaOrder.setTotalAmount(order.getTotalAmount());

		order.getPizzaLineItemCollection().forEach(t -> {
			PizzaLineItem pizzaLineItem = new LineItemBuilder()
					.withPizza(t.getPizza().getPizzaId())
					.withCrust(t.getCrust().getCustId())
					.withSize(t.getPizzaSize().getPizzaSizeId())
					.withTopping(t.getPizzaToppingCollection()).build();
			pizzaOrder.getPizzaLineItemCollection().add(pizzaLineItem);
			pizzaOrder.addAmount(pizzaLineItem.getPrice());
		});

		return this;
	}

	public PizzaOrder build() {
		return pizzaOrder;
	}

}
