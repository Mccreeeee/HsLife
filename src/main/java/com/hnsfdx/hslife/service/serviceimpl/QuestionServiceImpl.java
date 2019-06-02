package com.hnsfdx.hslife.service.serviceimpl;

import com.hnsfdx.hslife.pojo.Question;
import com.hnsfdx.hslife.repository.QuestionRepository;
import com.hnsfdx.hslife.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public void addQuestion(Question question) {
        questionRepository.insertOneQuestion(question);
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAllQuestions();
    }

    @Override
    public List<Question> getAllQuestionsByAuthorOpenId(String openId) {
        return questionRepository.findAllQuestionsByAuthorOpenId(openId);
    }

    @Override
    public List<Question> getAllQuestionsByTitle(String title) {
        return questionRepository.findAllQuestionsByTitle(title);
    }
}
