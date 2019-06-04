package com.hnsfdx.hslife.service;

import com.hnsfdx.hslife.pojo.Question;

import java.util.List;

public interface QuestionService {
    Integer addQuestion(Question question);
    //找到所有疑问
    List<Question> getAllQuestions(Integer offset, Integer size);
    //找到所有“我”发过的疑问
    List<Question> getAllQuestionsByAuthorOpenId(String openId);
    //找到搜索的类似标题的疑问
    List<Question> getAllQuestionsByTitle(String title, Integer offset, Integer size);
    //根据Comment的questionId列表来找“我”评论过的疑问
    List<Question> getAllQuestionsByQuestionId(List<Integer> questionIds);
}
