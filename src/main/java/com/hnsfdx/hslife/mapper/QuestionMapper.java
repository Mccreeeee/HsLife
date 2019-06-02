package com.hnsfdx.hslife.mapper;

import com.hnsfdx.hslife.pojo.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QuestionMapper {
    @Insert("INSERT INTO questions(title, content, author, publishdate, imgurl1, imgurl2, imgurl3, imgurl4)" +
            "VALUES " +
            "(#{title}, #{content}, #{author}, #{publishDate}, #{imgurl1}, #{imgurl2}, #{imgurl3}, #{imgurl4})")
    void insertOneQuestion(Question question);
    //找到所有疑问
    List<Question> findAllQuestions(@Param(value = "offset") Integer offset);
    //找到所有“我”发过的疑问
    List<Question> findAllQuestionsByAuthorOpenId(@Param(value = "openId") String openId);
    //找到搜索的类似标题的疑问
    List<Question> findAllQuestionsByTitle(@Param(value = "title") String title, @Param(value = "offset") Integer offset);
    //根据Comment的questionId列表来找“我”评论过的疑问
    List<Question> findAllQuestionsByQuestionId(@Param(value = "questionIds") List<Integer> questionIds);
}
