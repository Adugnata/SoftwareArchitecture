package com.interstatespeedservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class InterstateSpeedServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InterstateSpeedServiceApplication.class, args);
    }

}
