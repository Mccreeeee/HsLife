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
    public Integer addQuestion(Question question) {
        return questionRepository.insertOneQuestion(question);
    }

    @Override
    public List<Question> getAllQuestions(Integer offset, Integer size) {
        return questionRepository.findAllQuestions(offset, size);
    }

    @Override
    public List<Question> getAllQuestionsByAuthorOpenId(String openId) {
        return questionRepository.findAllQuestionsByAuthorOpenId(openId);
    }

    @Override
    public List<Question> getAllQuestionsByTitle(String title, Integer offset, Integer size) {
        return questionRepository.findAllQuestionsByTitle(title, offset, size);
    }

    @Override
    public List<Question> getAllQuestionsByQuestionId(List<Integer> questionIds) {
        return questionRepository.findAllQuestionsByQuestionId(questionIds);
    }

    @Override
    public Integer updateQuestion(Question question) {
        return questionRepository.updateSingleQuestion(question);
    }

    @Override
    public Integer deleteQuestion(Integer id) {
        return questionRepository.deleteSingleQuestion(id);
    }
}
