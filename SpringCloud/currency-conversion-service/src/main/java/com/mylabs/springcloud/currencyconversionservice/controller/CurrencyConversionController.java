package com.mylabs.springcloud.currencyconversionservice.controller;

import brave.sampler.Sampler;
import com.mylabs.springcloud.currencyconversionservice.CurrencyExchangeServiceProxy;
import com.mylabs.springcloud.currencyconversionservice.beans.CurrencyConversion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    CurrencyExchangeServiceProxy currencyExchangeServiceProxy;

    // Feign problem
    @GetMapping(path="/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion convertConcurrency(@PathVariable("from") String from,@PathVariable("to") String to,
                                                 @PathVariable("quantity") BigDecimal quantity){

        Map<String,String> uriVariables = new HashMap<>();
        uriVariables.put("from",from);
        uriVariables.put("to",to);

        ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",CurrencyConversion.class,uriVariables);
        CurrencyConversion currencyConversion = responseEntity.getBody();
        return new CurrencyConversion(currencyConversion.getId(),from,to,currencyConversion.getConversionMultiple(),
                quantity,quantity.multiply(currencyConversion.getConversionMultiple()),currencyConversion.getPortNumber());
    }


    @GetMapping(path="/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion convertConcurrencyFeign(@PathVariable("from") String from,@PathVariable("to") String to,
                                                 @PathVariable("quantity") BigDecimal quantity){

        CurrencyConversion currencyConversion = currencyExchangeServiceProxy.getExchangeValue(from,to);

        logger.info("{}",currencyConversion);

        return new CurrencyConversion(currencyConversion.getId(),from,to,currencyConversion.getConversionMultiple(),
                quantity,quantity.multiply(currencyConversion.getConversionMultiple()),currencyConversion.getPortNumber());
    }


    @Bean
    public Sampler defaultSampler(){
        return Sampler.ALWAYS_SAMPLE;
    }




}
