package com.mylabs.springrest.service;

import com.mylabs.springrest.beans.Employee;
import org.springframework.stereotype.Component;

public interface EmployeeService {

    public Employee getEmployee(int empId);

}
