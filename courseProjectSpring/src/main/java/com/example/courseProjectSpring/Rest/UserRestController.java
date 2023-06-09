package com.example.courseProjectSpring.Rest;

import com.example.courseProjectSpring.Model.User;
import com.example.courseProjectSpring.ServiceInterfaces.CustomerService;
import com.example.courseProjectSpring.ServiceInterfaces.RoleService;
import com.example.courseProjectSpring.ServiceInterfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserRestController {
    @Autowired
    private UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAllUsers();
    }

    @PostMapping("/isValidUser")
    public boolean isValidUser(@RequestBody User user) {
        boolean existence = userService.isValidUser(user.getLogin(), user.getPassword());
        return existence;
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/add")
        public ResponseEntity<User> addPerson(@RequestBody User user) {
        User newPerson = userService.save(user);
        return new ResponseEntity<>(newPerson, HttpStatus.CREATED);
    }
    @GetMapping("/byid")
    public ResponseEntity<?> getUser(@RequestBody User user) {
        Long userId = user.getId();
        Optional<User> findUser = userService.getById(userId);
        return new ResponseEntity<>(findUser, HttpStatus.OK);

    }
}
