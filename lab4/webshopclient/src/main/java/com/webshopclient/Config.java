package com.webshopclient;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@org.springframework.context.annotation.Configuration
public class Config {
    @Bean
    RestOperations restTemplate() {
        return new RestTemplate();
    }
}
