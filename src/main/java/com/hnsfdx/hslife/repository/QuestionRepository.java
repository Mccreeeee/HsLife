package com.hnsfdx.hslife.repository;

import com.hnsfdx.hslife.pojo.Question;

import java.util.List;

public interface QuestionRepository {
    void insertOneQuestion(Question question);
    //找到所有疑问
    List<Question> findAllQuestions();
    //找到所有“我”发过的疑问
    List<Question> findAllQuestionsByAuthorOpenId(String openId);
    //找到搜索的类似标题的疑问
    List<Question> findAllQuestionsByTitle(String title);
}
