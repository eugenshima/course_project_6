package com.example.courseProjectSpring.ServiceInterfaces;

import com.example.courseProjectSpring.Model.Customer;
import com.example.courseProjectSpring.Model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();

    User save(User user);

    void delete(Long id);

    boolean isLogin(User user);

    Optional<User> getById(Long id);

    boolean isValidUser(String login, String password);
}
