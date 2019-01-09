package com.calculator.calculatorgatewayservice.kafka;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class NotificationProducer {
    private static final Logger logger = LogManager.getLogger(NotificationProducer.class);

    @Autowired
    public KafkaTemplate<String,String> kafkaTemplate;

    public void send(String topic, String payload) {
        logger.info("PRODUCING - {}",payload);
        kafkaTemplate.send(topic, payload);
    }
}
