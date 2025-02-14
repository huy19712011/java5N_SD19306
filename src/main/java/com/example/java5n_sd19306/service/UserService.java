package com.example.java5n_sd19306.service;

import com.example.java5n_sd19306.entity.User;
import com.example.java5n_sd19306.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void addUser(User user) {

        userRepository.save(user);
    }

    public User readUserAndAssociatedRoles(long id) {

        return userRepository.findById(id).get();
    }
}
