package com.interstatespeedservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class SpeedService {

    @Autowired
    private Sender sender;
    @Value("${app.topic.fasttopic}")
    private String fasttopic;

    @KafkaListener(topics = {"cameratopic1" , "cameratopic2"})
    public void receive(@Payload SensorRecord sensorRecord,
                        @Headers MessageHeaders headers) {
        if (sensorRecord.getSecond() != 0) {
            double speed = (0.5 / sensorRecord.getSecond()) * 3600;
            sensorRecord.setSpeed(speed);

            System.out.println("License plate: "+ sensorRecord.getLicencePlate());
            System.out.println("Speed = " + speed);
            System.out.println("---------");

            if (speed > 72) {
                sender.send(fasttopic, sensorRecord);
            }
        }
    }
}
