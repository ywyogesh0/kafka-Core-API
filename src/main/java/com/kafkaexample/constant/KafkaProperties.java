package com.kafkaexample.constant;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

public final class KafkaProperties {

    // Producer(s)
    public static final String BOOTSTRAP_SERVERS_KEY = "bootstrap.servers";
    public static final String BOOTSTRAP_SERVERS_HOST = "127.0.0.1";
    public static final String BOOTSTRAP_SERVERS_PORT = "9092";

    public static final String SERIALIZER_KEY = "key.serializer";
    public static final String SERIALIZER_VALUE = "value.serializer";
    public static final String SERIALIZER_KEY_CLASS = StringSerializer.class.getName();
    public static final String SERIALIZER_VALUE_CLASS = StringSerializer.class.getName();

    public static final String ACKS_KEY = "acks";
    public static final String ACKS_VALUE = "1";

    public static final String RETRIES_KEY = "retries";
    public static final String RETRIES_VALUE = "3";

    public static final String LINGER_MS_KEY = "linger.ms";
    public static final String LINGER_MS_VALUE = "1";

    public static final String TOPIC = "kafka-topic-1";

    // Consumer(s)
    public static final String DESERIALIZER_KEY = "key.deserializer";
    public static final String DESERIALIZER_VALUE = "value.deserializer";
    public static final String DESERIALIZER_KEY_CLASS = StringDeserializer.class.getName();
    public static final String DESERIALIZER_VALUE_CLASS = StringDeserializer.class.getName();

    public static final String GROUP_ID_KEY = "group.id";
    public static final String GROUP_ID_VALUE = "kafka-consumer-1";

    public static final String ENABLE_AUTO_COMMIT_KEY = "enable.auto.commit";
    public static final String ENABLE_AUTO_COMMIT_VALUE = "false";

    public static final String AUTO_COMMIT_INTERVAL_MS_KEY = "auto.commit.interval.ms";
    public static final String AUTO_COMMIT_INTERVAL_MS_VALUE = "1000";

    public static final String AUTO_OFFSET_RESET_KEY = "auto.offset.reset";
    public static final String AUTO_OFFSET_RESET_VALUE = "earliest";
}
