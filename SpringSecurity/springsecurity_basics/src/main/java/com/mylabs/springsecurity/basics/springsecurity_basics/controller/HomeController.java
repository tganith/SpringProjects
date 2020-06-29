package com.mylabs.springsecurity.basics.springsecurity_basics.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class HomeController {

    @GetMapping(value = "/")
    public String hello(){
        return "Hello World";
    }

    @GetMapping(value = "/user")
    public String helloUser(){
        return "Hello User";
    }

    @GetMapping(value = "/admin")
    public String helloAdmin(){
        return "Hello Admin";
    }

}
