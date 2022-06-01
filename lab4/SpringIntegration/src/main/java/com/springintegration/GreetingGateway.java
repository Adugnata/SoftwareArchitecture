package com.springintegration;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface GreetingGateway {
    @Gateway(requestChannel = "inputChannel")
    String handleRequest(String name);
}
