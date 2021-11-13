package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.entities.User;
import com.bridgelabz.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;


    public User getUserByEmail(String userName){
        return userRepository.findUserByEmail(userName);
    }

    public User addUser(User user){
        return userRepository.save(user);
    }
}
