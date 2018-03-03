package com.spb.springdatajpa.controller;

import com.spb.springdatajpa.entity.UserEntity;
import com.spb.springdatajpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserRedisController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/findAll")
    public List<UserEntity> findAll(){
        return userService.findAll();
    }
}
