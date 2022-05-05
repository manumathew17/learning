package com.manu.learning.user.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.manu.learning.user.entity.EntityLoginRequest;
import com.manu.learning.user.entity.EntityResponse;
import com.manu.learning.user.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public EntityResponse loginUser(@RequestBody EntityLoginRequest loginRequest) throws JsonProcessingException {
        return loginService.loginUser(loginRequest);
    }

}
