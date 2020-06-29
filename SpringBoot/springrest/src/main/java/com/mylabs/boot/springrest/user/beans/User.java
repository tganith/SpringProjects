package com.mylabs.boot.springrest.user.beans;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

public class User {

    private int userId;
    @Size(min = 3,max = 10,message = "name must be between 3 and 10")
    private String name;
    @Past
    @NotBlank
    private Date birthDate;

    public User(int userId, String name, Date birthDate) {
        this.userId = userId;
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
