package com.run.cbbmessage.service.impl;


import com.run.cbbmessage.service.KafkaConsumerRest;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.PartitionInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.*;

@Service
public class KafkaConsumerRestImpl implements KafkaConsumerRest {


    @Value("${bootstrap_server}")
    private String bootstrap_server;

    @Value("${key_serializer}")
    private String key_serializer;

    @Value("${value_serializer}")
    private String value_serializer;


    @Override
    public String receive(String group_id, String topic) {

        StringBuilder sb = new StringBuilder();

        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrap_server);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
//        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, 1000);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, group_id);

        Consumer<String, String> consumer = new KafkaConsumer<String, String>(properties);

        consumer.subscribe(Arrays.asList(topic));
        Map<String, List<PartitionInfo>> maps = consumer.listTopics();
        List<String> topics = new ArrayList<>();
        for (String string : maps.keySet()) {
            topics.add(string);

        }
        System.out.println(topics);

        ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofSeconds(1));

        for (ConsumerRecord<String, String> consumerRecords1 : consumerRecords) {

            sb.append(consumerRecords1.topic() + "******" + consumerRecords1.partition() + "******" + consumerRecords1.offset() + "******" + consumerRecords1.key() + "******" + consumerRecords1.value());
            System.out.println(consumerRecords1.topic() + "******" + consumerRecords1.partition() + "******" + consumerRecords1.offset() + "******" + consumerRecords1.key() + "******" + consumerRecords1.value());
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        }
        consumer.close();
        return sb.toString();
    }


}
