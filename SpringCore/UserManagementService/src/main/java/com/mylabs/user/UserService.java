package com.mylabs.user;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    public List<User> getUsers(){

        List<User> userList = new ArrayList<>();

        userList.add(new User("ganitha","bangalore"));
        userList.add(new User("myuser","bangalore"));
        userList.add(new User("user","bangalore"));

        return userList;
    }
}
