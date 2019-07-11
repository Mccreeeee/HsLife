package com.hnsfdx.hslife.repository.repositoryimpl;

import com.hnsfdx.hslife.mapper.AnswerMapper;
import com.hnsfdx.hslife.pojo.Answer;
import com.hnsfdx.hslife.repository.AnswerRepository;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

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
    public Integer countAllAnswers(Integer enterId) {
        return answerMapper.countAllAnswers(enterId);
    }

    @Override
    public Integer doUserAnswer(Integer qid, String uid){return answerMapper.doUserAnswer(qid,uid);}

    @Override
    public List<Answer> find3FirstRightAnswer(Integer enterId, String rightAnswer) {
        return answerMapper.find3FirstRightAnswer(enterId, rightAnswer);
    }
}
