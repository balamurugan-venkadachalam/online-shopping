package com.bala.pizza.web.rest;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.bala.pizza.PizzaServiceApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PizzaServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PizzaControllerTest {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testRetrievePizzas() throws JSONException {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/pizzas"), HttpMethod.GET, entity,
				String.class);

		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());

	}

	private String createURLWithPort(String uri) {
		 return "http://localhost:" + port + uri;
	}

}
