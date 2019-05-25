package com.hnsfdx.hslife.mapper;

import com.hnsfdx.hslife.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
     User findByOpenId(@Param(value = "openId") String openId);
     List<User> findAllUsers();
     void insertOneUser(User user);
}
