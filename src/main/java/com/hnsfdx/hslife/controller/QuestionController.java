package com.hnsfdx.hslife.controller;

import com.alibaba.fastjson.JSONObject;
import com.hnsfdx.hslife.exception.*;
import com.hnsfdx.hslife.pojo.Comment;
import com.hnsfdx.hslife.pojo.CommentLikeRecord;
import com.hnsfdx.hslife.pojo.Question;
import com.hnsfdx.hslife.service.CommentService;
import com.hnsfdx.hslife.service.QuestionService;
import com.hnsfdx.hslife.service.serviceimpl.CommentLikeRecordServicelmpl;
import com.hnsfdx.hslife.util.FileUtils;
import com.hnsfdx.hslife.util.PageUtils;
import com.hnsfdx.hslife.util.ResponseTypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.rmi.UnexpectedException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/question")
public class QuestionController {
    private QuestionService questionService;
    private CommentService commentService;
    private CommentLikeRecordServicelmpl commentLikeRecord;
    @Autowired
    public QuestionController(QuestionService questionService, CommentService commentService,CommentLikeRecordServicelmpl commentLikeRecord) {
        this.questionService = questionService;
        this.commentService = commentService;
        this.commentLikeRecord = commentLikeRecord;
    }

    @PostMapping("/addquestion")
    public Map<String, Object> addQuestion(@RequestBody Question question) throws Exception {
        Integer result = questionService.addQuestion(question);
        Map<String, Object> res = ResponseTypeUtil.createDataOpResponse(result, question.getId(), new DataInsertException());
        return res;
    }

    @GetMapping("/getallquestions")
    public Map<String, Object> getAllQuestions(@RequestParam("page") Integer page) {
        if(page <= 0) {
            throw new ArgsIntroduceException();
        }
        List<Question> questionList = questionService.getAllQuestions((page - 1) * PageUtils.PAGESIZE, PageUtils.PAGESIZE);
        Map<String, Object> forRet = ResponseTypeUtil.createSucResponse();
        forRet.put("data", questionList);
        return forRet;
    }
    //所有疑问数量的最大页数
    @GetMapping("/getquestionsmaxpage")
    public Map<String, Object> getAllQuestionsMaxPage() {
        Integer count = questionService.getAllQuestionsCount();
        Map<String, Object> forRet = ResponseTypeUtil.createSucResponse();
        forRet.put("data", (int) Math.ceil(count * 1.0 / PageUtils.PAGESIZE));
        return forRet;
    }

    @GetMapping("/getallquestionsbyaid")
    public Map<String, Object> getAllQuestionsByAId(@RequestParam("openId") String openId) {
        List<Question> questionList = questionService.getAllQuestionsByAuthorOpenId(openId);
        Map<String, Object> forRet = ResponseTypeUtil.createSucResponse();
        forRet.put("data", questionList);
        return forRet;
    }

    //模糊搜索用
    @GetMapping("/getallquestionsbyt")
    public Map<String, Object> getAllQuestionsByT(@RequestParam("title") String title, @RequestParam("page") Integer page) {
        if(page <= 0) {
            throw new ArgsIntroduceException();
        }
        List<Question> questionList = questionService.getAllQuestionsByTitle(title, (page - 1) * PageUtils.PAGESIZE, PageUtils.PAGESIZE);
        Map<String, Object> forRet = ResponseTypeUtil.createSucResponse();
        forRet.put("data", questionList);
        return forRet;
    }
    //模糊搜索疑问的最大页数
    @GetMapping("/getquestionsbytmaxpage")
    public Map<String, Object> getAllQuestionsByTMaxPage(@RequestParam("title") String title) {
        Integer count = questionService.getAllQuestionsByTitleCount(title);
        Map<String, Object> forRet = ResponseTypeUtil.createSucResponse();
        forRet.put("data", (int) Math.ceil(count * 1.0 / PageUtils.PAGESIZE));
        return forRet;
    }

    //给出“我”评论过的所有疑问
    @GetMapping("/getallquestionsofme")
    public Map<String, Object> getAllQuestionsOfMe(@RequestParam("openId") String openId) {
        List<Integer> questionIds = commentService.getAllCommentsByReviewerOpenId(openId);
        List<Question> questionList = questionService.getAllQuestionsByQuestionId(questionIds);
        Map<String, Object> forRet = ResponseTypeUtil.createSucResponse();
        forRet.put("data", questionList);
        return forRet;
    }

    @PostMapping("/addcomment")
    public Map<String, Object> addComment(@RequestBody Comment comment) throws Exception {
        Integer result = commentService.addComment(comment);
        Map<String, Object> res = ResponseTypeUtil.createDataOpResponse(result, comment.getId(), new DataInsertException());
        return res;
    }

    @GetMapping("/getallcommentsbyqid")
    public Map<String, Object> getAllCommentsByQId(@RequestParam("questionId") Integer questionId, @RequestParam("page") Integer page) {
        if(page <= 0) {
            throw new ArgsIntroduceException();
        }
        List<Comment> commentList = commentService.getAllCommentsByQuesionId(questionId, (page - 1) * PageUtils.PAGESIZE, PageUtils.PAGESIZE);
        Map<String, Object> forRet = ResponseTypeUtil.createSucResponse();
        forRet.put("data", commentList);
        return forRet;
    }

    @GetMapping("/getmost3commentsbyqid")
    public Map<String, Object> getAllCommentsByQIdMost3(@RequestParam("questionId") Integer questionId) {
        List<Comment> commentList = commentService.getAllCommentsByQuesionIdMost3(questionId);
        Map<String, Object> forRet = ResponseTypeUtil.createSucResponse();
        forRet.put("data", commentList);
        return forRet;
    }

    @PostMapping("/updatequestion")
    public Map<String, Object> updateQuestion(@RequestBody Question question) throws Exception {
        Integer result = questionService.updateQuestion(question);
        Map<String, Object> res = ResponseTypeUtil.modDataOpResponse(result, new DataUpdateException());
        return res;
    }
    @PostMapping("/deletequestion")
    public Map<String, Object> deleteQuestion(Integer id) throws Exception {
        Integer result = questionService.deleteQuestion(id);
        Map<String, Object> res = ResponseTypeUtil.modDataOpResponse(result, new DataDeleteException());
        return res;
    }

    @PostMapping("/updatecomment")
    public Map<String, Object> updateComment(@RequestBody Comment comment) throws Exception {
        Integer result = commentService.updateComment(comment);
        Map<String, Object> res = ResponseTypeUtil.modDataOpResponse(result, new DataUpdateException());
        return res;
    }
    @PostMapping("/deletecomment")
    public Map<String, Object> deleteComment(Integer id) throws Exception {
        Integer result = commentService.deleteComment(id);
        Map<String, Object> res = ResponseTypeUtil.modDataOpResponse(result, new DataDeleteException());
        return res;
    }
    @GetMapping("/like")
    public Map<String,Object> sendCommentLike(@RequestParam Integer commentId, @RequestParam String reviewer){
        try{
            commentLikeRecord.insert(new CommentLikeRecord(commentId,reviewer));
            commentService.addLikeNumber(commentId);
            return ResponseTypeUtil.createSucResponse();
        } catch (DuplicateKeyException de){
            return ResponseTypeUtil.createFailResponse("Record already exits(user already like it) ");
        }catch (Exception e){
            throw new DataInsertException();
        }
    }
    @GetMapping("/cancelLike")
    public Map<String,Object> cancelCommentLike(@RequestParam Integer commentId, @RequestParam String reviewer){
        try{
            commentLikeRecord.delete(new CommentLikeRecord(commentId,reviewer));
            commentService.subLikeNumber(commentId);
            return ResponseTypeUtil.createSucResponse();
        }catch (Exception e){
            throw new DataDeleteException();
        }
    }
    @PostMapping("/isLiked")
    public Map<String,Object> isLikedComment(@RequestBody JSONObject jsonObject) {
        String openid = jsonObject.getString("openId");
        List<String> cids = (List<String>) jsonObject.get("commentIdList");
        HashSet<String> likeInString = null;
        List<Boolean> likeInBoolean = new LinkedList<>();
        try {
            likeInString = new HashSet(commentLikeRecord.isLiked(openid, cids));
        }catch (Exception e){
            return ResponseTypeUtil.createFailResponse("Database Exception");
        }
        for (String i : cids) {
            likeInBoolean.add(likeInString.contains(i));
        }
        return ResponseTypeUtil.createSucResponseWithData(likeInBoolean);
    }

    // 给出发布疑问的人的openId和疑问的Id以及上传的文件，将其保存在服务端，返回相对路径
    @PostMapping("/uploadimg")
    public Map<String,Object> uploadOneImage(@RequestParam("author") String author,
                                             @RequestParam("datetime") String datetime,
                                             @RequestParam("file") MultipartFile file) {
        String uploadPath = author + "/" + "question" + datetime + "/";
        Map<String, Object> forRet = ResponseTypeUtil.createSucResponse();
        try {
            forRet.put("data", FileUtils.uploadToServer(uploadPath, file));
        } catch (Exception e) {
            throw new StorageException();
        }
        return forRet;
    }

    // 给出发布疑问的人的openId和疑问的Id，删除对应相对路径下的所有文件
    @PostMapping("/deleteimg")
    public Map<String,Object> deleteOneImage(@RequestParam("author") String author,
                                             @RequestParam("datetime") String datetime) {
        String deletePath = author + "/" +  "question" + datetime + "/";
        Map<String, Object> forRet = ResponseTypeUtil.createSucResponse();
        try {
            FileUtils.deleteInServer(deletePath);
        } catch (Exception e) {
            throw new AuthException();
        }
        return forRet;
    }
}
