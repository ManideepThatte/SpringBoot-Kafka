package com.javatips.producers;

import com.javatips.model.KafkaJsonMesg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaJsonProducer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaJsonProducer.class);

    private final KafkaTemplate<String, KafkaJsonMesg> kafkaTemplate;

    @Value("${myapp.kafka.json-topic}")
    private String kafkaTopic;

    public KafkaJsonProducer(KafkaTemplate<String, KafkaJsonMesg> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendJsonMessage(KafkaJsonMesg json) {
        logger.info("Json Object producing from the UI: " + json);
        kafkaTemplate.send(kafkaTopic, json);
    }
}
