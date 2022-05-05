package com.manu.learning.user.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.manu.learning.user.entity.EntityLoginRequest;
import com.manu.learning.user.entity.EntityResponse;
import com.manu.learning.user.entity.EntityUserDetails;
import com.manu.learning.user.entity.UserEntity;
import com.manu.learning.user.service.LoginService;
import com.manu.learning.user.service.UserServices;
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
    @Autowired
    private UserServices userServices;

    @PostMapping("/login")
    public EntityResponse loginUser(@RequestBody EntityLoginRequest loginRequest) {
        return loginService.loginUser(loginRequest);
    }

    @PostMapping("/add")
    public EntityResponse addUser(@RequestBody UserEntity userDetails) {
        return userServices.saveUser(userDetails);

    }

}
