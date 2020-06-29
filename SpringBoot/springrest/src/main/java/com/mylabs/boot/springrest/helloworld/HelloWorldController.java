package com.mylabs.boot.springrest.helloworld;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    @RequestMapping(value = "/helloworld", method = RequestMethod.GET)
    public String helloWorld(){
        return "hello";
    }


    @GetMapping(value = "/helloworldbean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("hello world bean");
    }

    @GetMapping(value = "/helloworldbean/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable("name") String name){
        return new HelloWorldBean(String.format("Hello World %s",name));
    }

}
