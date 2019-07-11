package com.hnsfdx.hslife.mapper;

import com.hnsfdx.hslife.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {
     User findByOpenId(@Param(value = "openId") String openId);
     List<User> findAllUsers();
     Integer insertOneUser(User user);
     List<User> getBatchOfUser(@Param(value = "param_ids")List<String> ids);
     List<User> listUsersRank15();

     @Update("update users set score = score + #{score} where openid = #{id}")
     void addScore(@Param(value = "id") String id,@Param("score") Integer score);
}
