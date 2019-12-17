package com.run.cbbmessage.service.impl;


import com.run.cbbmessage.service.KafkaProducerRest;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class KafkaProducerRestImpl implements KafkaProducerRest {

    @Value("${bootstrap_server}")
    private String bootstrap_server;

    @Value("${key_serializer}")
    private String key_serializer;

    @Value("${value_serializer}")
    private String value_serializer;


    @Override
    public void send(String topic, Object object) {

        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrap_server);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, key_serializer);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, value_serializer);

        Producer<String, String> producer = new KafkaProducer<String, String>(properties);


        producer.send(new ProducerRecord<String, String>(topic, object.toString()), new Callback() {
            @Override
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                if (e == null) {

                    System.out.println(recordMetadata.topic() + "----------" + recordMetadata.partition() + "----------" + recordMetadata.offset());
                    System.out.println("####################");
                }
            }
        });

        producer.close();
    }
}
