package com.hnsfdx.hslife.repository.repositoryimpl;

import com.hnsfdx.hslife.mapper.AnswerMapper;
import com.hnsfdx.hslife.pojo.Answer;
import com.hnsfdx.hslife.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnswerRepositorylmpl implements AnswerRepository {

    private final AnswerMapper answerMapper;

    @Autowired
    public AnswerRepositorylmpl(AnswerMapper answerMapper){
        this.answerMapper=answerMapper;
    }

    @Override
    public Integer insertSingleAnswer(Answer answer){
        return answerMapper.insertOneAnswer(answer);
    }

    @Override
    public List<Answer> findAllAnswerByEntertainmentId(Integer enterId, Integer offset, Integer size){
       return answerMapper.findAllAnswerByEntertainmentId(enterId,offset,size);
    }

    @Override
    public Integer countAllAnswers() {
        return answerMapper.countAllAnswers();
    }
}
