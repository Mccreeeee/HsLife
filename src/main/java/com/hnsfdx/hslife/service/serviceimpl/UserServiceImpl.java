package com.hnsfdx.hslife.service.serviceimpl;

import com.hnsfdx.hslife.exception.DataInsertException;
import com.hnsfdx.hslife.pojo.User;
import com.hnsfdx.hslife.repository.UserRepository;
import com.hnsfdx.hslife.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
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
    public User getUser(String openId) {
        return userRepository.findByOpenId(openId);
    }

    @Override
    public Integer addUser(User user) {
        return userRepository.insertOneUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAllUsers();
    }

    @Override
    public boolean tryAddUser(User user){
        try{
            addUser(user);
            return true;
        }catch (DuplicateKeyException e){
            throw new DataInsertException();
        }
    }

    @Override
    public List<User> getBatchOfUser(List<String> batchOfOpendId){
        return userRepository.getBatchOfUser(batchOfOpendId);
    }

    @Override
    public List<User> getUsersRank15() {
        return userRepository.listUsersRank15();
    }

    @Override
    public void addScore(String id,Integer score){userRepository.addScore(id,score);}
}
