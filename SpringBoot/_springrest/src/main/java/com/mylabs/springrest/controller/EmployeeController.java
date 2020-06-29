package com.mylabs.springrest.controller;

import com.mylabs.springrest.beans.Employee;
import com.mylabs.springrest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employee/{id}" , method = RequestMethod.GET)
    public Employee getEmployee(@PathVariable("id") int empId) {
         return employeeService.getEmployee(empId);
    }


}
