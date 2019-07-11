package com.hnsfdx.hslife.repository;

import com.hnsfdx.hslife.pojo.User;

import java.util.List;

public interface UserRepository {
    User findByOpenId(String openId);
    List<User> findAllUsers();
    Integer insertOneUser(User user);
    List<User> getBatchOfUser(List<String> batchOfOpendId);
    List<User> listUsersRank15();
    void addScore(String id,Integer score);
}
