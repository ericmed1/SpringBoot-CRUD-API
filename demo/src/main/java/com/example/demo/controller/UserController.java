package com.example.demo.controller;

import com.example.demo.models.User;
import com.example.demo.service.UserService;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    // injects userService into the UserController
    public UserController(UserService userService){
        this.userService = userService;
    }

    // Create User
    // this is the Post command 
    // the @RequestBody User user makes it so it coverts the incoming JSON file into a User object
    // then it will use the createUser function from the userService file so we can create a new user
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // get all users
    // this is the Get command 
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    //Get User by ID
    // the getMapping hadles the HTTP Get /users/{id} requests
    // the pathVariable gets the id from the url
    // calls the getUserByID functions from userService so that we can get the desired user info
    // if the user exist then it will return the ok and the user data
    // if not then it will return 404 not found
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //update User
    // this is the Put command 
    // this will get the id from the url then it will take in the JSON data and convert it to a newUser
    // if it can find the user then it will but the id and newUser info into the User
    // if it is not found it will return error 404 
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User newUser){
        try{
            return ResponseEntity.ok(userService.updateUser(id, newUser));
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    // Delete user
    // this is the Delete command
    // this takes in the id from the url then it will delete the user at that id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
