package com.hnsfdx.hslife.mapper;

import com.hnsfdx.hslife.pojo.Answer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AnswerMapper {
    @Insert("INSERT INTO answer(entertainmentid, content, reviewer, publishdate)" +
            "VALUES " +
            "(#{entertainmentid}, #{content}, #{reviewer}, #{publishdate})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Integer insertOneComment(Answer answer);

    //找到某个疑问下的所有评论
    List<Answer> findAllAnswerByEntertainmentId(@Param(value = "questionId") Integer enterId,
                                          @Param(value = "offset") Integer offset,
                                          @Param(value = "size") Integer size);
}
