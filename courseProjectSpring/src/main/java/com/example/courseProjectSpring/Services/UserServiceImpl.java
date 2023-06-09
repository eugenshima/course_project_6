package com.example.courseProjectSpring.Services;

import com.example.courseProjectSpring.Model.Customer;
import com.example.courseProjectSpring.Model.Role;
import com.example.courseProjectSpring.Model.User;
import com.example.courseProjectSpring.Repository.UserRepository;
import com.example.courseProjectSpring.ServiceInterfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.ignoreCase;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public void delete(Long id) {
        User user = userRepository.findUserById(id);
        userRepository.delete(user);
    }

    @Transactional
    @Override
    public User save(User user) {
        Customer customer = new Customer();
        customer.setUser(user);

        user.setCustomer(customer);
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public boolean isValidUser(String username, String password) {
        User user = userRepository.findByLogin(username);
        if (user != null) {
            //String password = user.getPassword();
            return password.equals(user.getPassword());
        }
        return false;
    }
    @Transactional
    @Override
    public boolean isLogin(User user) {
        ExampleMatcher modelMatcher = ExampleMatcher.matching().withIgnorePaths("id").withMatcher(user.getPassword(), ignoreCase());
        Example<User> example = Example.of(user, modelMatcher);
        //boolean exists = userRepository.exists(example);
        return userRepository.exists(example);
    }
    @Transactional
    @Override
    public Optional<User> getById(Long id) {
        //    log.info("IN CustomerServiceImpl getById {}");
        return userRepository.findById(id);
    }
}
