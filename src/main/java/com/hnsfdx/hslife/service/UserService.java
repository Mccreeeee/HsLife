package com.hnsfdx.hslife.service;

import com.hnsfdx.hslife.pojo.User;

import java.util.List;

public interface UserService {
    User getUser(String openId);
    Integer addUser(User user);
    List<User> getAllUsers();
}
