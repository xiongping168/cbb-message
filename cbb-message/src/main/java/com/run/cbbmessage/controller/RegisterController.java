package com.run.cbbmessage.controller;

import com.run.cbbmessage.entity.Register;
import com.run.cbbmessage.service.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @Autowired
    private RegisterRepository registerRepository;


    @PostMapping("/register")
    public String register(Register register) {
        registerRepository.save(register);
        return "注册成功";
    }

}
