package com.mylabs.boot.springrest.user.controller;

import com.mylabs.boot.springrest.user.beans.User;
import com.mylabs.boot.springrest.user.dao.UserDAOService;
import com.mylabs.boot.springrest.user.exceptions.UserNotFoundException;
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

    @GetMapping(path = "/users")
    public List<User> getAllUsers(){
        return userDAOService.findAll();
    }

    @PostMapping(path = "/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser = userDAOService.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(savedUser.getUserId()).toUri();

        return ResponseEntity.created(location).build();
    }

   @GetMapping(path = "/users/{id}")
   public User getUser(@PathVariable("id") int userId){
       User user = userDAOService.findOne(userId);
       if(user == null){
           throw new UserNotFoundException(userId+" is not found");
       }
       return user;
   }

    @DeleteMapping(path = "/users/{id}")
    public void deleteUser(@PathVariable("id") int userId){
       User deleteUser = userDAOService.deleteUser(userId);
       if(deleteUser == null){
           throw new UserNotFoundException(userId+" is not found");
       }
    }

}
