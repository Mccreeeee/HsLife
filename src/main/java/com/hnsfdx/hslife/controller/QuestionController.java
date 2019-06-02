package com.hnsfdx.hslife.controller;

import com.hnsfdx.hslife.pojo.Comment;
import com.hnsfdx.hslife.pojo.Question;
import com.hnsfdx.hslife.service.CommentService;
import com.hnsfdx.hslife.service.QuestionService;
import com.hnsfdx.hslife.util.ResponseTypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    private QuestionService questionService;
    private CommentService commentService;
    @Autowired
    public QuestionController(QuestionService questionService, CommentService commentService) {
        this.questionService = questionService;
        this.commentService = commentService;
    }

    @PostMapping("/addquestion")
    public String addQuestion(@RequestBody Question question) {
        questionService.addQuestion(question);
        //需要异常处理，后续再优化
        return ResponseTypeUtil.BOOLEAN_SUC;
    }

    @GetMapping("/getallquestions")
    public List<Question> getAllQuestions(@RequestParam("offset") Integer offset) {
        return questionService.getAllQuestions(offset);
    }

    @GetMapping("/getallquestionsbyaid")
    public List<Question> getAllQuestionsByAId(@RequestParam("openId") String openId) {
        return questionService.getAllQuestionsByAuthorOpenId(openId);
    }
    //模糊搜索用
    @GetMapping("/getallquestionsbyt")
    public List<Question> getAllQuestionsByT(@RequestParam("title") String title, @RequestParam("offset") Integer offset) {
        return questionService.getAllQuestionsByTitle(title, offset);
    }

    //给出“我”评论过的所有疑问
    @GetMapping("/getallquestionsofme")
    public List<Question> getAllQuestionsOfMe(@RequestParam("openId") String openId) {
        List<Integer> questionId = commentService.getAllCommentsByReviewerOpenId(openId);
        return questionService.getAllQuestionsByQuestionId(questionId);
    }

    @PostMapping("/addcomment")
    public String addComment(@RequestBody Comment comment) {
        commentService.addComment(comment);
        //需要异常处理，后续再优化
        return ResponseTypeUtil.BOOLEAN_SUC;
    }

    @GetMapping("/getallcommentsbyqid")
    public List<Comment> getAllCommentsByQId (@RequestParam("questionId") Integer questionId, @RequestParam("offset") Integer offset) {
        return commentService.getAllCommentsByQuesionId(questionId, offset);
    }

    @GetMapping("/getmost3commentsbyqid")
    public List<Comment> getAllCommentsByQIdMost3 (@RequestParam("questionId") Integer questionId) {
        return commentService.getAllCommentsByQuesionIdMost3(questionId);
    }

}
