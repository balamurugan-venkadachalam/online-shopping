package com.bala.pizza.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrderNotCreatedException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 735463345279317196L;

	public OrderNotCreatedException() {

	}

	public OrderNotCreatedException(String string) {
		super(string);
	}

}