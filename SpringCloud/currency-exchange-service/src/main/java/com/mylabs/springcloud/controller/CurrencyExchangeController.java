package com.mylabs.springcloud.controller;

import com.mylabs.springcloud.beans.ExchangeValue;
import com.mylabs.springcloud.dao.CurrencyExchangeValueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Environment environment;

    @Autowired
    CurrencyExchangeValueRepository repository;


    @GetMapping(path = "/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue getExchangeValue(@PathVariable("from") String from,@PathVariable("to") String to){
         ExchangeValue exchangeValue = repository.findByFromAndTo(from,to);
        exchangeValue.setPortNumber(Integer.parseInt(environment.getProperty("local.server.port")));

        logger.info("{}",exchangeValue);
        return exchangeValue;
    }

}
