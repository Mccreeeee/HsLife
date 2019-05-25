package com.hnsfdx.hslife.controller;

import com.hnsfdx.hslife.pojo.User;
import com.hnsfdx.hslife.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/adduser")
    public String addUser(@RequestBody User user) {
        userService.addUser(user);
        return "success!";
    }

    @GetMapping("/test")
    public String test(){
        return userService.getAllUsers().toString();
    }
}
