package com.mylabs.boot.springrest.jpa.user.controller;

import com.mylabs.boot.springrest.jpa.user.beans.Post;
import com.mylabs.boot.springrest.jpa.user.beans.User;
import com.mylabs.boot.springrest.jpa.user.exceptions.UserNotFoundException;
import com.mylabs.boot.springrest.jpa.user.repository.PostRepository;
import com.mylabs.boot.springrest.jpa.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/jpa")
public class UserJpaController {

    @Autowired
    UserRepository userRepository;


    @Autowired
    PostRepository postRepository;

    @GetMapping("/users")
    public List<User> getAllUsers(){

        List<User> usersList = userRepository.findAll();
        if((usersList == null) ||(usersList!=null && usersList.isEmpty())){
            throw new UserNotFoundException("No Data Found");
        }
        return usersList;
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id") int userId){

        Optional<User> user = userRepository.findById(userId);

        if(!user.isPresent()){
            throw new UserNotFoundException(String.format("user %s not exist",userId));
        }
        return user.get();
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid  @RequestBody User user){
         User savedUser = userRepository.save(user);
         URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                        .buildAndExpand(savedUser.getId()).toUri();

         return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable("id") int userId) {
        userRepository.deleteById(userId);
    }



    @GetMapping("/users/{id}/posts")
    public List<Post> retrieveAllPosts(@PathVariable("id") int userId){

        Optional<User> user = userRepository.findById(userId);

        if(!user.isPresent()){
            throw new UserNotFoundException(String.format("user %s not exist",userId));
        }
        return user.get().getPosts();
    }


    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Object> createPost(@PathVariable("id") int userId,@RequestBody Post post){

        Optional<User> user = userRepository.findById(userId);

        if(!user.isPresent()){
            throw new UserNotFoundException(String.format("user %s not exist",userId));
        }

        User optionalUser = user.get();
        post.setUser(optionalUser);

        postRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(post.getId()).toUri();

        return ResponseEntity.created(location).build();
    }


}
