package com.mylabs.boot.springrest._user.service;

import com.mylabs.boot.springrest._user.beans.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDAOService {

    private static List<User> users = new ArrayList<>();

    private static int count = 3;

    static {
        users.add(new User(1000,"user1",new Date()));
        users.add(new User(2000,"user2",new Date()));
        users.add(new User(3000,"user3",new Date()));

    }


    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        user.setId(++count);
        users.add(user);

        return user;
    }

    public User findOne(int id){

        for(User user :users){
            if(user.getId() == id){
                return user;
            }
        }

       return null;
    }

    public User deleteById(int userId) {

        Iterator iterator = users.iterator();

        while(iterator.hasNext()){
           User user = (User) iterator.next();
           if(user.getId()== userId){
               iterator.remove();
               return user;
           }
        }
        return null;
    }
}
