package com.javatips.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class KafkaStringTopicConsumer {

    private final static Logger log = LoggerFactory.getLogger(KafkaStringTopicConsumer.class);

    @KafkaListener(topics = "${myapp.kafka.topic}" , groupId = "${spring.kafka.consumer.group-id}")
    public void readMesg(String mesg) {
        log.info("Message from kafka Topic: "+ mesg);
    }
}
