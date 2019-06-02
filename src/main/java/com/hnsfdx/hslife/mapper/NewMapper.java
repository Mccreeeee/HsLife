package com.hnsfdx.hslife.mapper;

import com.hnsfdx.hslife.pojo.New;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface NewMapper {
    @Insert("INSERT INTO news(title, content, author, publishdate) " +
            "VALUES" +
            "(#{title}, #{content}, #{author}, #{publishDate})")
    void insertOneNew(New oneNew);
    //注解方式
//    @Select("SELECT * FROM news")
//    @Results({
//            @Result(id = true, property = "id", column = "id", jdbcType = JdbcType.INTEGER),
//            @Result(property = "title", column = "title", jdbcType = JdbcType.VARCHAR),
//            @Result(property = "content", column = "content", jdbcType = JdbcType.LONGVARCHAR),
//            @Result(property = "author", column = "author", jdbcType = JdbcType.VARCHAR),
//            @Result(property = "publishDate", column = "publishdate", jdbcType = JdbcType.DATE)
//    })
    List<New> findAllNews(@Param(value = "offset") Integer offset);
}
