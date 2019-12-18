package com.run.cbbmessage.controller;

import com.run.cbbmessage.entity.Register;
import com.run.cbbmessage.service.RegisterRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @Autowired
    private RegisterRepository registerRepository;


    @ApiOperation(value = "注册中心", notes = "注册中心")
    @PostMapping("/register")
    public String register(@RequestBody Register register) {
        registerRepository.save(register);
        return "注册成功";
    }

}
