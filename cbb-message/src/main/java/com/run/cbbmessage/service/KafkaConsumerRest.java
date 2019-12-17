package com.run.cbbmessage.service;

public interface KafkaConsumerRest {

    public String receive(String group_id, String topic);
}
