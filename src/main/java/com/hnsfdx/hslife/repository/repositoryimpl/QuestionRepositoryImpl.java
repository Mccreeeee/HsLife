package com.hnsfdx.hslife.repository.repositoryimpl;

import com.hnsfdx.hslife.mapper.QuestionMapper;
import com.hnsfdx.hslife.pojo.Question;
import com.hnsfdx.hslife.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionRepositoryImpl implements QuestionRepository {

    private final QuestionMapper questionMapper;

    @Autowired
    public QuestionRepositoryImpl(QuestionMapper questionMapper) {
        this.questionMapper = questionMapper;
    }

    @Override
    public Integer insertOneQuestion(Question question) {
        return questionMapper.insertOneQuestion(question);
    }

    @Override
    public List<Question> findAllQuestions(Integer offset, Integer size) {
        return questionMapper.findAllQuestions(offset, size);
    }

    @Override
    public Integer countAllQuestions() {
        return questionMapper.countAllQuestions();
    }

    @Override
    public List<Question> findAllQuestionsByAuthorOpenId(String openId) {
        return questionMapper.findAllQuestionsByAuthorOpenId(openId);
    }

    @Override
    public List<Question> findAllQuestionsByTitle(String title, Integer offset, Integer size) {
        return questionMapper.findAllQuestionsByTitle(title, offset, size);
    }

    @Override
    public Integer countAllQuestionsByTitle(String title) {
        return questionMapper.countAllQuestionsByTitle(title);
    }

    @Override
    public List<Question> findAllQuestionsByQuestionId(List<Integer> questionIds) {
        return questionMapper.findAllQuestionsByQuestionId(questionIds);
    }

    @Override
    public Integer updateSingleQuestion(Question question) {
        return questionMapper.updateSingleQuestion(question);
    }

    @Override
    public Integer deleteSingleQuestion(Integer id) {
        return questionMapper.deleteSingleQuestion(id);
    }
}
