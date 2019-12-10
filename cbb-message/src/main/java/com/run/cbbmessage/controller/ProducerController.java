package com.run.cbbmessage.controller;

import com.run.cbbmessage.entity.Message;
import com.run.cbbmessage.service.KafkaProducerRest;
import com.run.cbbmessage.service.impl.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProducerController {



    @Autowired
    Producer producer;

    @Autowired
    private KafkaProducerRest kafkaProducerRest;

    @RequestMapping(value = "/sendMessage/complexType", method = RequestMethod.POST)
    public String publishMessageComplextType(@RequestBody Message payload) {
        producer.getSource().output().send(MessageBuilder.withPayload(payload).setHeader("type", "chatMessage").build());
        return "success";
    }



    @PostMapping("/sendMessage")
    public void send(String topic,Object object){
        kafkaProducerRest.send(topic,object);
    }



}
