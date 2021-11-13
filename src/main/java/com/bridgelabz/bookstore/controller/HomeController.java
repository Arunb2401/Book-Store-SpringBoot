package com.bridgelabz.bookstore.controller;

import com.bridgelabz.bookstore.dto.LoginDTO;
import com.bridgelabz.bookstore.entities.User;
import com.bridgelabz.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class HomeController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PostMapping("/changePassword")
    public String changePassword(@RequestBody LoginDTO loginDTO){
        String response = "user not found of given user name";

        User userByEmail = userService.getUserByEmail(loginDTO.getUserName());
        if (userByEmail != null){
            userByEmail.setPassword(loginDTO.getPassword());
            userService.addUser(userByEmail);
            response = "password changed successfully";
        }
        return response;

    }
}
