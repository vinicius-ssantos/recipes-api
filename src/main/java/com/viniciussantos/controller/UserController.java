package com.viniciussantos.controller;


import com.viniciussantos.model.User;
import com.viniciussantos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private  UserRepository userRepository;



    @PostMapping("api/user")
    public User createUser(@RequestBody User user) throws Exception {
       User userExists = userRepository.findByEmail(user.getEmail());
        if (userExists != null) {
            throw new Exception("User already exists with email: " + user.getEmail());
        }

        return userRepository.save(user);
    }


    @DeleteMapping("api/user/{id}")
    public String deleteUser(@PathVariable Long id) throws Exception {
         userRepository.deleteById(id);
        return "User deleted successfully";

    }

    @GetMapping("api/user")
    public List<User> getAllUsers() throws Exception {
        return userRepository.findAll();
    }




}
