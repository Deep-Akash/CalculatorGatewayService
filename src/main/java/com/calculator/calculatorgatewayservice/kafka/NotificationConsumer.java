package com.calculator.calculatorgatewayservice.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationConsumer {
    private static final Logger logger = LogManager.getLogger(NotificationConsumer.class);

    @KafkaListener(topics = "testtopic", groupId = "boot")
    public void receive(ConsumerRecord<?, ?> consumerRecord) {
        logger.info("CONSUMER - {}", consumerRecord.toString());
    }
}
