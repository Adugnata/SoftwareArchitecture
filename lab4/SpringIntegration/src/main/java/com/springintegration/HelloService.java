package com.springintegration;

import org.springframework.messaging.MessagingException;

public class HelloService {
    public void getGreeting(String name) throws MessagingException {
        System.out.println("Hello " + name);
    }
}
