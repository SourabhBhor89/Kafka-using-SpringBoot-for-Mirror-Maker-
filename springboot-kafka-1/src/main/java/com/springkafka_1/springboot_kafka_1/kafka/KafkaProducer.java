package com.springkafka_1.springboot_kafka_1.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    // Method to send a message to the "target-topic"
    public void sendMessage(String message) {
        LOGGER.info("Sending message: {}", message);
        kafkaTemplate.send("JAVA", message); // Ensure this matches your target topic name
    }
}










//package com.springkafka_1.springboot_kafka_1.kafka;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//@Service
//public class KafkaProducer {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
//
//    private final KafkaTemplate<String, String> kafkaTemplate;
//
//    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
//
//    // Method to send a message to the "target-topic"
//    public void sendMessage(String message) {
//        LOGGER.info("Sending message: {}", message);
//        kafkaTemplate.send("target-topic", message); // Ensure this matches your target topic name
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
////import org.slf4j.ILoggerFactory;
////import org.slf4j.Logger;
////import org.slf4j.LoggerFactory;
////import org.springframework.kafka.core.KafkaTemplate;
////import org.springframework.stereotype.Service;
////
////@Service
////public class KafkaProducer {
////
////
////    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
////
////    private KafkaTemplate<String, String> kafkaTemplate;
////
////    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
////        this.kafkaTemplate = kafkaTemplate;
////    }
////
////
////    public void sendMessage(String message){
////        LOGGER.info(String.format("Message sent %s", message));
////        kafkaTemplate.send("JAVA", message);
////    }
////}
