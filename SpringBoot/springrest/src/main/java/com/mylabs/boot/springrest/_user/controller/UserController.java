package com.mylabs.boot.springrest._user.controller;

import com.mylabs.boot.springrest._user.beans.User;
import com.mylabs.boot.springrest._user.exceptions.UserNotFoundException;
import com.mylabs.boot.springrest._user.service.UserDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
public class UserController {

    @Autowired
    UserDAOService userDAOService;

    @GetMapping("/users")
    public List<User> getAllUsers(){

        List<User> usersList = userDAOService.findAll();
        if((usersList == null) ||(usersList!=null && usersList.isEmpty())){
            throw new UserNotFoundException("No Data Found");
        }
        return usersList;
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id") int userId){

        User user = userDAOService.findOne(userId);

        if(user == null){
            throw new UserNotFoundException(String.format("user %s not exist",userId));
        }
        return userDAOService.findOne(userId);
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid  @RequestBody User user){
         User savedUser = userDAOService.save(user);
         URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                        .buildAndExpand(savedUser.getId()).toUri();

         return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable("id") int userId){
        User user = userDAOService.deleteById(userId);
        if(user == null){
            throw new UserNotFoundException("user not exist");
        }
    }


}
