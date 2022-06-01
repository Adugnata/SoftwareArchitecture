package com.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

@SpringBootApplication
@ImportResource("classpath:config.xml")
public class OrderApplication {

	public static void main(String[] args) {
		ApplicationContext context = new
				ClassPathXmlApplicationContext("config.xml");
		Order order = new Order("H-234-X56",1245.75, true);
		Order order2 = new Order("H-234-X57",600.65, false);
		Order order3 = new Order("H-234-X58",50600.65, true);
		Message<Order> orderMessage = MessageBuilder.withPayload(order).build();
		Message<Order> orderMessage2 = MessageBuilder.withPayload(order2).build();
		Message<Order> orderMessage3 = MessageBuilder.withPayload(order3).build();
		MessageChannel inputChannel = context.getBean("orderreceivechannel",
				MessageChannel.class);
		inputChannel.send(orderMessage);
		inputChannel.send(orderMessage2);
		inputChannel.send(orderMessage3);
	}

}
