package com.mylabs.boot.springrest.helloworld;

public class HelloWorldBean {

    public String message;


    HelloWorldBean(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
