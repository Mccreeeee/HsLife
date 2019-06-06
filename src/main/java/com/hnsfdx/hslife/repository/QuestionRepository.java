package com.hnsfdx.hslife.repository;

import com.hnsfdx.hslife.pojo.Question;

import java.util.List;

public interface QuestionRepository {
    Integer insertOneQuestion(Question question);
    //找到所有疑问
    List<Question> findAllQuestions(Integer offset, Integer size);
    //找到所有“我”发过的疑问
    List<Question> findAllQuestionsByAuthorOpenId(String openId);
    //找到搜索的类似标题的疑问
    List<Question> findAllQuestionsByTitle(String title, Integer offset, Integer size);
    //根据Comment的questionId列表来找“我”评论过的疑问
    List<Question> findAllQuestionsByQuestionId(List<Integer> questionIds);
    //更新一条疑问
    Integer updateSingleQuestion(Question question);
    //删除一条疑问
    Integer deleteSingleQuestion(Integer id);
}
