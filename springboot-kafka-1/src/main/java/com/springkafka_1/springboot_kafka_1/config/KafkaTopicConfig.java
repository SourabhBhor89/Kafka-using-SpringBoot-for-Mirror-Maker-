package com.springkafka_1.springboot_kafka_1.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.*;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaTopicConfig {

    // Source Kafka Cluster Configuration (Consume from here)
    @Bean
    public ConsumerFactory<String, String> sourceConsumerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"); // Update this to your source cluster address
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "myGroup");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        return new DefaultKafkaConsumerFactory<>(config);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> sourceKafkaListenerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(sourceConsumerFactory());
        return factory;
    }

    // Target Kafka Cluster Configuration (Produce to here)
    @Bean
    public ProducerFactory<String, String> targetProducerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"); // Update this to your target cluster address
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return new DefaultKafkaProducerFactory<>(config);
    }

    @Bean
    public KafkaTemplate<String, String> targetKafkaTemplate() {
        return new KafkaTemplate<>(targetProducerFactory());
    }

    // Topic creation on target cluster
    @Bean
    public NewTopic targetClusterTopic() {
        return TopicBuilder.name("my-topic").build(); // Make sure this matches your actual target topic name
    }

    // Topic creation on source cluster (if needed)
    @Bean
    public NewTopic sourceClusterTopic() {
        return TopicBuilder.name("JAVA").build(); // Make sure this matches your actual source topic name
    }
}








//package com.springkafka_1.springboot_kafka_1.config;
//
//import org.apache.kafka.clients.admin.NewTopic;
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.apache.kafka.common.serialization.StringSerializer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.EnableKafka;
//import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
//import org.springframework.kafka.config.TopicBuilder;
//import org.springframework.kafka.core.*;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//@EnableKafka
//public class KafkaTopicConfig {
//
//    // Source Kafka Cluster Configuration (Consume from here)
//    @Bean
//    public ConsumerFactory<String, String> sourceConsumerFactory() {
//        Map<String, Object> config = new HashMap<>();
//        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"); // Source Kafka cluster address
//        config.put(ConsumerConfig.GROUP_ID_CONFIG, "myGroup");
//        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
//        return new DefaultKafkaConsumerFactory<>(config);
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, String> sourceKafkaListenerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(sourceConsumerFactory());
//        return factory;
//    }
//
//    // Target Kafka Cluster Configuration (Produce to here)
//    @Bean
//    public ProducerFactory<String, String> targetProducerFactory() {
//        Map<String, Object> config = new HashMap<>();
//        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"); // Target Kafka cluster address
//        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        return new DefaultKafkaProducerFactory<>(config);
//    }
//
//    @Bean
//    public KafkaTemplate<String, String> targetKafkaTemplate() {
//        return new KafkaTemplate<>(targetProducerFactory());
//    }
//
//    // Topic creation on target cluster
//    @Bean
//    public NewTopic targetClusterTopic() {
//        return TopicBuilder.name("target-topic").build();
//    }
//
//}
//
//
//
//
//
//
//
////package com.springkafka_1.springboot_kafka_1.config;
////
////
////import org.apache.kafka.clients.admin.NewTopic;
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.kafka.config.TopicBuilder;
////
////@Configuration
////public class KafkaTopicConfig {
////    @Bean
////    public NewTopic javaguidesTopic(){
////        return TopicBuilder.name("JAVA")
////                .build();
////    }
////}
