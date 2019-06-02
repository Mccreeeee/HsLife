package com.hnsfdx.hslife.controller;

import com.hnsfdx.hslife.pojo.User;
import com.hnsfdx.hslife.service.UserService;
import com.hnsfdx.hslife.util.ResponseTypeUtil;
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
        //此处要加异常处理，后续再进行优化
        return ResponseTypeUtil.BOOLEAN_SUC;
    }

    @PostMapping("/getuser")
    public User getUser(String openId) {
        return userService.getUser(openId);
    }

    @GetMapping("/test")
    public User test(String t) {
        User sss = userService.getUser(t);
        return sss;
    }
}
