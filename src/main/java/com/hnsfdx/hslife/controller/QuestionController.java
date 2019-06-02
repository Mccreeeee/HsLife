package com.hnsfdx.hslife.controller;

import com.hnsfdx.hslife.pojo.Question;
import com.hnsfdx.hslife.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    private QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/addquestion")
    public String addQuestion(@RequestBody Question question) {
        questionService.addQuestion(question);
        //需要异常处理，后续再优化
        return "success!";
    }

    @GetMapping("/getallquestions")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/getallquestionsbyaid")
    public List<Question> getAllQuestionsByAId(@RequestParam("openId") String openId) {
        return questionService.getAllQuestionsByAuthorOpenId(openId);
    }

    @GetMapping("/getallquestionsbyt")
    public List<Question> getAllQuestionsByT(@RequestParam("title") String title) {
        return questionService.getAllQuestionsByTitle(title);
    }
}
