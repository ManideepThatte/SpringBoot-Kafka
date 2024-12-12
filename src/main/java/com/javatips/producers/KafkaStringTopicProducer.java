package com.javatips.producers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaStringTopicProducer {

    private static final Logger log = LoggerFactory.getLogger(KafkaStringTopicProducer.class);

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${myapp.kafka.topic}")
    private String kafkaTopic;

    public KafkaStringTopicProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String mesg) {
        log.info("String Topic Name: " + kafkaTopic + " Message" + mesg);
        kafkaTemplate.send(kafkaTopic, mesg);

    }
}
