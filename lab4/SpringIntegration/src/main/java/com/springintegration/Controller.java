package com.springintegration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private GreetingGateway gateway;
    @RequestMapping(value = "/greeting/{name}")
    public String getGreeting(@PathVariable("name") String name){
        return gateway.handleRequest(name);
    }
}
