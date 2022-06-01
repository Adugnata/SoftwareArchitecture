package com.ownerservice;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {
    @Autowired
    private Sender sender;
    @Value("${app.topic.ownertopic}")
    private String ownertopic;

    @KafkaListener(topics = {"fasttopic"})
    public void receive(@Payload SensorRecord sensorRecord,
                        @Headers MessageHeaders headers) {
        sensorRecord.setOwnerInfo(getOwnerName());

        System.out.println("License plate: "+ sensorRecord.getLicencePlate());
        System.out.println("Owner = " + sensorRecord.getOwnerInfo());
        System.out.println("---------");

        sender.send(ownertopic, sensorRecord);
    }

    private String getOwnerName() {
        Faker faker = new Faker();
        return faker.name().fullName();
    }
}
