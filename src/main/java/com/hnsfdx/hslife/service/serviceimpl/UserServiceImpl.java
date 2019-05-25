package com.hnsfdx.hslife.service.serviceimpl;

import com.hnsfdx.hslife.pojo.User;
import com.hnsfdx.hslife.repository.UserRepository;
import com.hnsfdx.hslife.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(User user) {
        userRepository.insertOneUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAllUsers();
    }
}
