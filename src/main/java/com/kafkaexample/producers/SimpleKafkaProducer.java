package com.kafkaexample.producers;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

import static com.kafkaexample.constant.KafkaProperties.*;

public class SimpleKafkaProducer {

    public static void main(String[] args) {

        Properties properties = new Properties();

        properties.setProperty(BOOTSTRAP_SERVERS_KEY, BOOTSTRAP_SERVERS_HOST + ":" + BOOTSTRAP_SERVERS_PORT);
        properties.setProperty(SERIALIZER_KEY, SERIALIZER_KEY_CLASS);
        properties.setProperty(SERIALIZER_VALUE, SERIALIZER_VALUE_CLASS);
        properties.setProperty(ACKS_KEY, ACKS_VALUE);
        properties.setProperty(RETRIES_KEY, RETRIES_VALUE);
        properties.setProperty(LINGER_MS_KEY, LINGER_MS_VALUE);

        Producer<String, String> producer = new KafkaProducer<String, String>(properties);

        for (int i = 0; i < 5; i++) {
            ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(TOPIC,
                    String.valueOf(i), "message = " + String.valueOf(i));

            // Async
            producer.send(producerRecord);
        }

        producer.close();
    }
}
