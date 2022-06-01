package com.feecalculatorservice;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class FeeCalculatorService {

    @KafkaListener(topics = {"ownertopic"})
    public void receive(@Payload SensorRecord sensorRecord,
                        @Headers MessageHeaders headers) {

        int fee = 0;
        if (sensorRecord.getSpeed() < 77) {
            fee = 25;
        } else if (sensorRecord.getSpeed() < 82) {
            fee = 45;
        } else if (sensorRecord.getSpeed() <= 90) {
            fee = 80;
        } else {
            fee = 125;
        }

        System.out.println("License plate: "+ sensorRecord.getLicencePlate());
        System.out.println("Owner = " + sensorRecord.getOwnerInfo());
        System.out.println("Speed = " + sensorRecord.getSpeed());
        System.out.println("Fee Amount = " + fee);
        System.out.println("---------");
    }
}
