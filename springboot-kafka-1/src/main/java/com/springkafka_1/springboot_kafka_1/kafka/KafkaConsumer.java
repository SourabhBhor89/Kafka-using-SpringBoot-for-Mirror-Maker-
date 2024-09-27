package com.springkafka_1.springboot_kafka_1.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    // Inject the KafkaTemplate for producing messages to the target cluster
    private final KafkaTemplate<String, String> targetKafkaTemplate;

    public KafkaConsumer(KafkaTemplate<String, String> targetKafkaTemplate) {
        this.targetKafkaTemplate = targetKafkaTemplate;
    }

    // Listen to the source cluster's topic and mirror messages to the target cluster
    @KafkaListener(topics = "JAVA", groupId = "myGroup", containerFactory = "sourceKafkaListenerFactory")
    public void consumeAndMirror(String message) {
        LOGGER.info("Message consumed from source cluster: {}", message);

        // Mirror the message to the target cluster
        targetKafkaTemplate.send("my-topic", message);
        LOGGER.info("Message mirrored to target cluster: {}", message);
    }

}










//package com.springkafka_1.springboot_kafka_1.kafka;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//@Service
//public class KafkaConsumer {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
//
//    // Inject the KafkaTemplate for producing messages to the target cluster
//    private final KafkaTemplate<String, String> targetKafkaTemplate;
//
//    public KafkaConsumer(KafkaTemplate<String, String> targetKafkaTemplate) {
//        this.targetKafkaTemplate = targetKafkaTemplate;
//    }
//
//    // Listen to the source cluster's topic and mirror messages to the target cluster
//    @KafkaListener(topics = "source-topic", groupId = "mirror-group", containerFactory = "sourceKafkaListenerFactory")
//    public void consumeAndMirror(String message) {
//        LOGGER.info("Message consumed from source cluster: {}", message);
//
//        // Mirror the message to the target cluster
//        targetKafkaTemplate.send("target-topic", message);
//        LOGGER.info("Message mirrored to target cluster: {}", message);
//    }
//}
//
//
//
//
//
//
//
//
//
//
////package com.springkafka_1.springboot_kafka_1.kafka;
////
////
////import org.slf4j.Logger;
////import org.slf4j.LoggerFactory;
////import org.springframework.kafka.annotation.KafkaListener;
////import org.springframework.stereotype.Service;
////
////@Service
////public class KafkaConsumer {
////
////
////    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
////
////    @KafkaListener(topics = "JAVA", groupId = "myGroup")
////    public void consume (String message){
////        LOGGER.info(String.format("Message Received -> %s", message));
////
////    }
////
////}
