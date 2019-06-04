package com.hnsfdx.hslife.repository;

import com.hnsfdx.hslife.pojo.Answer;

import java.util.List;

public interface AnswerRepository {

    Integer insertSingleAnswer(Answer answer);

    List<Answer> findAllAnswerByEntertainmentId(Integer enterId, Integer offset, Integer size);
}
