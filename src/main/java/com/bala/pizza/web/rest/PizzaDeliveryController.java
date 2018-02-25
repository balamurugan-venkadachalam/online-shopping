package com.bala.pizza.web.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bala.pizza.domain.model.PizzaOrder;
import com.bala.pizza.service.PizzaDeliveryService;

/**
 * This service is used to deliver the pizza
 * @author engan.bala
 *
 */
@RestController
public class PizzaDeliveryController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PizzaDeliveryService pizzaDeliveryService;
	
	/**
	 * This service is used to delete order
	 * @param orderId pizza order id
	 * @return http status with order deleted status message
	 */
	@GetMapping("/pizza/delivery/{orderId}")
	public ResponseEntity<?> markDelivered(@PathVariable Long orderId){
		logger.info("pizza delivery orderid {}", orderId);
		
		pizzaDeliveryService.deleteDelivery(orderId);
		return ResponseEntity.ok().body("Iteam marked as delivered");
	}
	
	/**
	 * This method is used to fetch all orders for delivery
	 * @return
	 */
	@GetMapping("/pizza/delivery/orders")
	public @ResponseBody List<PizzaOrder> getOrders(){
		return pizzaDeliveryService.fetchOrders();
	}
	
	
	

}
