package com.hnsfdx.hslife.service;

import com.hnsfdx.hslife.pojo.Answer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnswerService {
    Integer addSingleAnswer(Answer answer);

    List<Answer> getAllAnswerByEntertainmentId(Integer EnterId,Integer offset, Integer size);

    //所有答案的数量
    Integer getAllAnswersCount(Integer enid);
}
