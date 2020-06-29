package com.mylabs.springrest.service;

import com.mylabs.springrest.beans.Employee;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    public Employee getEmployee(int empId){

        return new Employee(100,"Ganitha");
    }

}
