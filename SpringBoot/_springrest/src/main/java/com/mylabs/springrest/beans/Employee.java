package com.mylabs.springrest.beans;

public class Employee {

    private int empId;
    private String empName;
    private Address Address;


    public Employee(int empId,String empName){
        this.empId = empId;
        this.empName = empName;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public com.mylabs.springrest.beans.Address getAddress() {
        return Address;
    }

    public void setAddress(com.mylabs.springrest.beans.Address address) {
        Address = address;
    }
}
