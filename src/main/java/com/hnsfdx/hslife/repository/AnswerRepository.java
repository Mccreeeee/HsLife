package com.hnsfdx.hslife.repository;

import com.hnsfdx.hslife.pojo.Answer;

import java.util.List;

public interface AnswerRepository {

    Integer insertSingleAnswer(Answer answer);

    List<Answer> findAllAnswerByEntertainmentId(Integer enterId, Integer offset, Integer size);

    //所有回答的数量
    Integer countAllAnswers(Integer enterId);

    Integer doUserAnswer( Integer qid, String uid);

    //找到对应entertainmentId以及正确答案的回答
    List<Answer> find3FirstRightAnswer(Integer enterId, String rightAnswer);
}
