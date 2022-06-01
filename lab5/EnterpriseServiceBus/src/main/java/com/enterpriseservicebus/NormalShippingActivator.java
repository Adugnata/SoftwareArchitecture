package com.enterpriseservicebus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class NormalShippingActivator {
	@Autowired
	RestTemplate restTemplate;

	public void ship(Order order) {
		System.out.println("normal shipping: "+ order.toString());
		restTemplate.postForLocation("http://localhost:8082/orders/normal_shipping", order);
	}
}
