package com.hnsfdx.hslife.controller;

import com.hnsfdx.hslife.exception.DataInsertException;
import com.hnsfdx.hslife.pojo.User;
import com.hnsfdx.hslife.service.UserService;
import com.hnsfdx.hslife.util.ResponseTypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/adduser")
    public Map<String, Object> addUser(@RequestBody User user) {
        Integer result = userService.addUser(user);
        Map<String, Object> res;
        if(result == 0){
            throw new DataInsertException();
        }else {
            res = ResponseTypeUtil.createSucResponse();
        }
        return res;
    }

    @GetMapping("/getuser")
    public Map<String,Object> getUser(@RequestParam("openId") String openId) {
        User user = userService.getUser(openId);
        Map<String,Object> forRet =  ResponseTypeUtil.createSucResponse();
        forRet.put("data",user);
        return forRet;
    }

    @GetMapping("/test")
    public User test(String t) {
        User sss = userService.getUser(t);
        return sss;
    }
}
