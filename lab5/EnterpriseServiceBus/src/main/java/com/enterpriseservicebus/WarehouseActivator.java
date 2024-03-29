
package com.enterpriseservicebus;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class WarehouseActivator {

	@Autowired
	RestTemplate restTemplate;

	public Order checkStock(Order order) {
		System.out.println("WarehouseService: checking order "+order.toString());
		restTemplate.postForLocation("http://localhost:8081/orders", order);
		return order;
	}
}
