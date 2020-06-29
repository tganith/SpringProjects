package com.mylabs.boot.springrest.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    // static filter @JsonIgnore
    @GetMapping(path = "/filtering-static/users")
    public User getUser(){
        return new User(100,"rahul",new Date(),"mypassword");
    }


    // filter all except password and birthdate
    @GetMapping(path = "/filtering-dynamic/users")
    public MappingJacksonValue getUserBean(){
        UserDynamic userDynamic = new UserDynamic(100,"rahul",new Date(),"mypassword");

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("birthDate","password");
        FilterProvider filters = new SimpleFilterProvider().addFilter("userdynamic",filter);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(userDynamic);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }


    // filter all except id,name,birhdate
    @GetMapping(path = "/filtering-dynamic/users-list")
    public MappingJacksonValue getUserAll(){
        List<UserDynamic> list = Arrays.asList(new UserDynamic(100,"rahul",new Date(),"mypassword"),new UserDynamic(101,"vijay",new Date(),"mypassword"));

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("userId","name","birthDate");
        FilterProvider filters = new SimpleFilterProvider().addFilter("userdynamic",filter);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }

}
