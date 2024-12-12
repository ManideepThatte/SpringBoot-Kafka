package com.javatips.config;

import org.apache.juli.logging.Log;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;


@Configuration
public class KafkaTopicConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(KafkaTopicConfiguration.class);
    @Value("${myapp.kafka.topic}")
    public String stringTopic;

    @Value("${myapp.kafka.json-topic}")
    public String jsonTopic;

    @Bean
    public NewTopic getStringTopic(){
        logger.info("Topic Name : "+stringTopic);
        return TopicBuilder.name(stringTopic).build();
    }

    @Bean
    public NewTopic getJsonTopic(){
        logger.info("Json Topic Name: "+jsonTopic);
        return  TopicBuilder.name(jsonTopic).build();
    }
}
