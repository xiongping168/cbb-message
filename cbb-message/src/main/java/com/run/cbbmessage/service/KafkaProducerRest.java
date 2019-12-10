package com.run.cbbmessage.service;

public interface KafkaProducerRest {



    public void send(String topic, Object object);

}
