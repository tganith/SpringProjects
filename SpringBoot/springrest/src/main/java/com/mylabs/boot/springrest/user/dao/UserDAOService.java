package com.mylabs.boot.springrest.user.dao;

import com.mylabs.boot.springrest.user.beans.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDAOService {


    static List<User> users = new ArrayList<>();
    static int count = 0;

    static{
        users.add(new User(1,"rahul",new Date()));
        users.add(new User(2,"vijay",new Date()));
        users.add(new User(3,"arjun",new Date()));
    }

    public List<User> findAll() {
        return users;
    }


    public User save(User user){
        count = users.size();
        user.setUserId(++count);
        users.add(user);
        return user;
    }

    public User findOne(int userId){
        for(User user:users){
            if(user.getUserId() == userId){
                return user;
            }
        }
        return null;
    }

    public User deleteUser(int userId) {

        Iterator<User> iterator = users.iterator();
        while(iterator.hasNext()){
            User user = iterator.next();
            if(user.getUserId() == userId){
                users.remove(user);
                return user;
            }
        }
        return null;
    }
}
