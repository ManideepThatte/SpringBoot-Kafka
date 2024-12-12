package com.javatips.controller;

import com.javatips.producers.KafkaStringTopicProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StringKafkaController {

    KafkaStringTopicProducer topicProducer;

    public StringKafkaController(KafkaStringTopicProducer topicProducer) {
        this.topicProducer = topicProducer;
    }

    @GetMapping("/welcome")
    public String hello(){
        return "hello";
    }

    @GetMapping("/getFirst/{mesg}")
    public String postMesg(@PathVariable String mesg) {
        topicProducer.sendMessage(mesg);
        return "Message Received and published by Producer";
    }
}
