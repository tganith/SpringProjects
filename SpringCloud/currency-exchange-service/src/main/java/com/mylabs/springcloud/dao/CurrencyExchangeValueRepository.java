package com.mylabs.springcloud.dao;


import com.mylabs.springcloud.beans.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeValueRepository extends JpaRepository<ExchangeValue,Long> {


    ExchangeValue findByFromAndTo(String from,String to);

}
