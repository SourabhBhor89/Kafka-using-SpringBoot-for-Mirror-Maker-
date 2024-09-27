package com.springkafka_1.springboot_kafka_1.controller;

import com.springkafka_1.springboot_kafka_1.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    private final KafkaProducer kafkaProducer;

    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    // http://localhost:8080/api/v1/kafka/publish?message=hello world
    @RequestMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to the consumer topic");
    }
}











//package com.springkafka_1.springboot_kafka_1.controller;
//
//
//import com.springkafka_1.springboot_kafka_1.kafka.KafkaProducer;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/v1/kafka")
//public class messageController {
//
//    private KafkaProducer kafkaProducer;
//
//    public messageController(KafkaProducer kafkaProducer) {
//        this.kafkaProducer = kafkaProducer;
//    }
//
//    // http:localhost:8080/api/v1/kafka/publish?message=hello world
//    @RequestMapping("/publish")
//    public ResponseEntity<String> publish(@RequestParam("message") String message){
//        kafkaProducer.sendMessage(message);
//        return ResponseEntity.ok("Message sent to the topic");
//    }
//
//}
