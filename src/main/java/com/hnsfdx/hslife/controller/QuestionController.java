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
    public List<Question> getAllQuestions(@RequestParam("offset") Integer offset) {
        return questionService.getAllQuestions(offset);
    }

    @GetMapping("/getallquestionsbyaid")
    public List<Question> getAllQuestionsByAId(@RequestParam("openId") String openId) {
        return questionService.getAllQuestionsByAuthorOpenId(openId);
    }

    @GetMapping("/getallquestionsbyt")
    public List<Question> getAllQuestionsByT(@RequestParam("title") String title, @RequestParam("offset") Integer offset) {
        return questionService.getAllQuestionsByTitle(title, offset);
    }

//    //给出“我”评论过的所有疑问
//    @GetMapping("/getallquestionsofme")
//    public List<Question> getAllQuestionsOfMe(@RequestParam("openId") String openId) {
//
//    }
}
