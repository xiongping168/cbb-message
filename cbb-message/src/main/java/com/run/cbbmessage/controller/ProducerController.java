package com.run.cbbmessage.controller;

import com.run.cbbmessage.entity.Message;
import com.run.cbbmessage.entity.Register;
import com.run.cbbmessage.service.KafkaConsumerRest;
import com.run.cbbmessage.service.KafkaProducerRest;
import com.run.cbbmessage.service.RegisterRepository;
import com.run.cbbmessage.service.impl.Producer;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ProducerController {

    @Autowired
    Producer producer;

    @Autowired
    private KafkaProducerRest kafkaProducerRest;

    @Autowired
    private KafkaConsumerRest kafkaConsumerRest;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RegisterRepository registerRepository;

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String publishMessageComplextType(@RequestBody Message payload) {
        producer.getSource().output().send(MessageBuilder.withPayload(payload).setHeader("type", "chatMessage").build());
        return "success";
    }


//    @PostMapping("/sendMessage")
//    public void send(String topic,Object object){
//
//        kafkaProducerRest.send(topic,object);
//
//        List<Register> registers=registerRepository.findAll();
//        registers.stream().filter(register -> register.getTopic().equals(topic))
//                          .map(register -> register.getSubscribeUrl())
//                          .forEach(()->{
//                        restTemplate.
//
//                          });
//
//
//
//    }

    @ApiOperation(value = "发送消息", notes = "发送消息")
    @PostMapping("/sendMessage")
    public void send(@RequestBody Message message){

        kafkaProducerRest.send(message.getHeader().getTopic(),message);

        List<Register> registers=registerRepository.findAll();
        System.out.println("***************");
        System.out.println(registers);
        System.out.println("***************");
        registers.stream().filter(register -> register.getTopic().equals(message.getHeader().getTopic()))
                .map(register -> register.getSubscribeUrl())
                .forEach((url)->{
                    System.out.println(url);
                   String string= restTemplate.postForObject(url, message, String.class);

                });



    }


    @PostMapping("/receiveMessage")
    public String receive(String group_id,String topic) {
        return kafkaConsumerRest.receive(group_id,topic);
    }




}
