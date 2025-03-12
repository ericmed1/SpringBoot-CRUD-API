package com.example.demo.service;

import com.example.demo.models.User; // importing the User data table from models
import com.example.demo.repository.UserRepository; // import the crud operations
// importing Autowire so we can inject dependenys
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; // importing the service bean to mark classes as a service

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository; // ensures that userRepository is immutable

    // this is making it so we can inject the dependency automatically aka the userRepository
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository; // we are setting the private userRepository from the UserService class and making it equal to the fetched userRepository
    }

    // create users function
    // this function create a new User function createUser that takes in the current user 
    // then using the premade crud operations from userRepository it saves the user into the User table
    public User createUser(User user){
        return userRepository.save(user);
    }

    // Get all users
    // this function returns the List of users by calling the userRepository pre made function findAll()
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    // Get User by ID
    // this gets the user by the declared id then uses the userRepository .findByID() function to return the specific user
    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    //Update User
    // this function adds a new user with the current id and the newUser witch will contain the new name and new user
    // it will then find the requested id the user inputed then if found it will return the newUser name and email and return
    // the saved user 
    // if it is not found it will return an error
    public User updateUser(Long id, User newUser){
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    return userRepository.save(user);
                }).orElseThrow(() -> new RuntimeException("User Not Found"));
    }

    // Delete User
    // this function takes in the users desired id they want deleted and then deletes user by the id number
    public void deleteUser(long id){
        userRepository.deleteById(id);
    }
    
}
