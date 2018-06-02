package com.kafkaexample.consumers;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.Properties;

import static com.kafkaexample.constant.KafkaProperties.*;

public class SimpleKafkaConsumer {

    public static void main(String[] args) {

        Properties properties = new Properties();

        properties.setProperty(BOOTSTRAP_SERVERS_KEY, BOOTSTRAP_SERVERS_HOST + ":" + BOOTSTRAP_SERVERS_PORT);
        properties.setProperty(DESERIALIZER_KEY, DESERIALIZER_KEY_CLASS);
        properties.setProperty(DESERIALIZER_VALUE, DESERIALIZER_VALUE_CLASS);
        properties.setProperty(GROUP_ID_KEY, GROUP_ID_VALUE);
        properties.setProperty(ENABLE_AUTO_COMMIT_KEY, ENABLE_AUTO_COMMIT_VALUE);
        // properties.setProperty(AUTO_COMMIT_INTERVAL_MS_KEY, AUTO_COMMIT_INTERVAL_MS_VALUE);
        properties.setProperty(AUTO_OFFSET_RESET_KEY, AUTO_OFFSET_RESET_VALUE);

        Consumer<String, String> consumer = new KafkaConsumer<String, String>(properties);
        consumer.subscribe(Collections.singletonList(TOPIC));

        while (true) {
            ConsumerRecords<String, String> consumerRecords = consumer.poll(1000);
            for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
                System.out.println("Partition: " + consumerRecord.partition() +
                        ", Offset: " + consumerRecord.offset() +
                        ", Key: " + consumerRecord.key() +
                        ", Value: " + consumerRecord.value());

            }

            consumer.commitSync();
        }
    }
}
