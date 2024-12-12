package com.javatips.controller;

import com.javatips.model.KafkaJsonMesg;
import com.javatips.producers.KafkaJsonProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class KafkaJsonController {

    private static final Logger log = LoggerFactory.getLogger(KafkaJsonController.class);
    private final KafkaJsonProducer jsonProducer;

    public KafkaJsonController(KafkaJsonProducer jsonProducer) {
        this.jsonProducer = jsonProducer;
    }

    @PostMapping("/jsonMesg")
    public String sendJson(@RequestBody KafkaJsonMesg json) {
        log.info("From KafkaJsonController json Object received: " + json);
        //json.setDate(LocalDateTime.now());
        jsonProducer.sendJsonMessage(json);
        return "Message successfully send to kafka Producer";
    }
}
