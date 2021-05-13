package com.mylabs.boot.springrest.helloworld;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class HelloWorldController {

    @Value("{${customer-mapping}}")
    private String customerKeys;

    @RequestMapping(value = "/helloworld", method = RequestMethod.GET)
    public String helloWorld() throws Exception{
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

   /* public void getProperties(){
        configProperties.setCustomerKey("PgPDIhAPBGxC0BZXAvBVkSkk7nCKoQRd");
    }*/

}
