package com.Notus_IT_Solution.AR_Genometype_API.controllers;

import com.Notus_IT_Solution.AR_Genometype_API.entity.Users;
import com.Notus_IT_Solution.AR_Genometype_API.repository.UserRepository;
import com.Notus_IT_Solution.AR_Genometype_API.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UsersController {

    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public UsersController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<Users> findAll() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public Users findById(@PathVariable int id) {
        Users getUser = userService.findById(id);
        if (getUser == null) {
            throw new RuntimeException("User not found");
        }
       return getUser;
    }

    @GetMapping("/users/random")
    public Users findRandomUser() {
        return userService.findRandomUser();
    }

    @GetMapping("/users/random/{num}")
    public List<Users> findRandomUsers(@PathVariable int num) {
        List<Users> randomUserList = new ArrayList<>();
        return userService.findRandomUsers(num);
    }

    @PostMapping("/users")
    public Users save(@RequestBody Users user) {
        return userService.save(user);
    }

}
