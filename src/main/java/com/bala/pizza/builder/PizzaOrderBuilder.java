package com.bala.pizza.builder;

import java.util.function.Consumer;

import com.bala.pizza.domain.model.PizzaLineItem;
import com.bala.pizza.domain.model.PizzaOrder;

@Deprecated
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
					.withTopping(t.getToppingIds()).build();
			pizzaOrder.getPizzaLineItemCollection().add(pizzaLineItem);
		});

		return this;
	}

	public PizzaOrder build() {
		return pizzaOrder;
	}

}
