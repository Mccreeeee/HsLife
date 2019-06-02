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
    public void insertOneQuestion(Question question) {
        questionMapper.insertOneQuestion(question);
    }

    @Override
    public List<Question> findAllQuestions() {
        return questionMapper.findAllQuestions();
    }

    @Override
    public List<Question> findAllQuestionsByAuthorOpenId(String openId) {
        return questionMapper.findAllQuestionsByAuthorOpenId(openId);
    }

    @Override
    public List<Question> findAllQuestionsByTitle(String title) {
        return questionMapper.findAllQuestionsByTitle(title);
    }
}
