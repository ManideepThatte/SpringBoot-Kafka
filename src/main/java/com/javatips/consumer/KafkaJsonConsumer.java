package com.javatips.consumer;

import com.javatips.model.KafkaJsonMesg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaJsonConsumer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaJsonConsumer.class);

    @KafkaListener(topics = "${myapp.kafka.json-topic}", groupId = "${spring.kafka.consumer.group-id}")
    public static void read(KafkaJsonMesg json) {
        logger.info("Read the Json Message from the producer: " + json);

    }
}
