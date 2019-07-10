package com.hnsfdx.hslife.service.serviceimpl;

import com.hnsfdx.hslife.pojo.Answer;
import com.hnsfdx.hslife.repository.AnswerRepository;
import com.hnsfdx.hslife.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.annotation.AnnotationSupport;

import java.util.List;

@Service
public class AnswerServicelmpl implements AnswerService {
    private AnswerRepository answerRepository;

    @Autowired
    public AnswerServicelmpl(AnswerRepository answerRepository){
        this.answerRepository = answerRepository;
    }

    @Override
    public Integer addSingleAnswer(Answer answer){
        return answerRepository.insertSingleAnswer(answer);
    }
    @Override
    public List<Answer> getAllAnswerByEntertainmentId(Integer enterId,Integer offset, Integer size){
        return answerRepository.findAllAnswerByEntertainmentId(enterId,offset,size);
    }

    @Override
    public Integer getAllAnswersCount(Integer enId) {
        return answerRepository.countAllAnswers(enId);
    }

    @Override
    public Integer doUserAnswer( Integer qid, String uid){return answerRepository.doUserAnswer(qid,uid);}
}
