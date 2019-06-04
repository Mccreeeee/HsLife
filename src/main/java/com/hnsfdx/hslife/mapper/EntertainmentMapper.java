package com.hnsfdx.hslife.mapper;

import com.hnsfdx.hslife.pojo.Entertainment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EntertainmentMapper {
    @Insert({"INSERT INTO entertainments(title,content,publishdate,imgurl1,imgurl2,imgurl3,imgurl4)" +
            "VALUES" +
            "(#{en.title},#{en.content},#{en.publishdate},#{en.imgurl1},#{en.imgurl2},#{en.imgurl3},#{en.imgurl4})"})
    @SelectKey(statement = "select last_insert_id() as nid", keyProperty = "en.id",before = false,resultType = Integer.class,keyColumn = "nid")
    @ResultType(Integer.class)
    Integer insertSingle(@Param("en") Entertainment entertainment);

    List<Entertainment> findEntertainmentById(@Param(value = "id") Integer id);

    List<Entertainment> findEntertainments(@Param(value = "lindex") Integer firstIndex, @Param(value = "lsize") Integer size);

    Integer countEntertainmentsNumber();
}
