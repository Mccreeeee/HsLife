package com.hnsfdx.hslife.mapper;

import com.hnsfdx.hslife.pojo.Entertainment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EntertainmentMapper {
    @Insert("INSERT INTO entertainment(id,title,content,publishdate,imgur1,imgurl2,imgurl3,imgurl4)" +
            "VALUES" +
            "(#{id},#{title},#{content},#{publishdate},#{imgurl1},#{imgurl2},#{imgurl3},#{imgurl4}),")
    void insertSingle(Entertainment entertainment);

    List<Entertainment> findEntertainmentById(@Param(value = "id") Integer id);

    List<Entertainment> findEntertainments(@Param(value = "lindex") Integer firstIndex, @Param(value = "lsize") Integer size);
}
