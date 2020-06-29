package com.mylabs.springcloud.limitsservice.controller;

import com.mylabs.springcloud.limitsservice.beans.LimitConfiguration;
import com.mylabs.springcloud.limitsservice.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

    @Autowired
    Configuration configuration;

    @GetMapping(path = "/limits")
    public LimitConfiguration getLimitsFromConfigurations(){
       return new LimitConfiguration(configuration.getMinimum(),configuration.getMaximum());
    }

}
