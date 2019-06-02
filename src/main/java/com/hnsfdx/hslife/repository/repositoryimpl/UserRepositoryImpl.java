package com.hnsfdx.hslife.repository.repositoryimpl;

import com.hnsfdx.hslife.pojo.User;
import com.hnsfdx.hslife.mapper.UserMapper;
import com.hnsfdx.hslife.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserRepositoryImpl implements UserRepository {
    private final UserMapper userMapper;

    @Autowired
    public UserRepositoryImpl(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    @Override
    public User findByOpenId(String openId) {
        return userMapper.findByOpenId(openId);
    }

    @Override
    public List<User> findAllUsers() {
        return userMapper.findAllUsers();
    }

    @Override
    public void insertOneUser(User user) {
        userMapper.insertOneUser(user);
    }
}
