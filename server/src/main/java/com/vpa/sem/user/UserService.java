package com.vpa.sem.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Iterable<User> GetUsers() {
        Iterable<User> users = userRepository.findAll();

        return users;
    }

    public User GetUser(int userId) {
        User user = userRepository.findById(userId).get();

        return user;
    }

    public boolean RegisterNewUser() {
        return false;
    }
}
