package com.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class OrderServiceApplication implements CommandLineRunner {
    @Autowired
    RestTemplate restTemplate;
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Override
    public void run(String... args) throws Exception {
        restTemplate.postForLocation("http://localhost:8080/orders", new Order("334", 123.0, Order.OrderType.DOMESTIC));
        restTemplate.postForLocation("http://localhost:8080/orders", new Order("355", 120.0, Order.OrderType.INTERNATIONAL));
        restTemplate.postForLocation("http://localhost:8080/orders", new Order("355", 120.0, Order.OrderType.DOMESTIC));
        restTemplate.postForLocation("http://localhost:8080/orders", new Order("355", 160.0, Order.OrderType.INTERNATIONAL));
    }
}
