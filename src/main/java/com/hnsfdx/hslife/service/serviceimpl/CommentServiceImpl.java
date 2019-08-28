package com.hnsfdx.hslife.service.serviceimpl;

import com.hnsfdx.hslife.annotation.ReadCache;
import com.hnsfdx.hslife.annotation.WriteCache;
import com.hnsfdx.hslife.pojo.Comment;
import com.hnsfdx.hslife.repository.CommentRepository;
import com.hnsfdx.hslife.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @WriteCache(value = "comment")
    @Override
    public Integer addComment(Comment comment) {
        return commentRepository.insertOneComment(comment);
    }

    @ReadCache(value = "comment")
    @Override
    public List<Comment> getAllCommentsByQuesionId(Integer questionId, Integer offset, Integer size) {
        return commentRepository.findAllCommentsByQuesionId(questionId, offset, size);
    }

    @Override
    public Integer getAllCommentsCount() {
        return commentRepository.countAllComments();
    }

    @ReadCache(value = "comment")
    @Override
    public List<Comment> getAllCommentsByQuesionIdMost3(Integer questionId) {
        return commentRepository.findAllCommentsByQuesionIdMost3(questionId);
    }

    @ReadCache(value = "comment")
    @Override
    public List<Integer> getAllCommentsByReviewerOpenId(String openId) {
        return commentRepository.findAllCommentsByReviewerOpenId(openId);
    }

    @WriteCache(value = "comment")
    @Override
    public Integer updateComment(Comment comment) {
        return commentRepository.updateSingleComment(comment);
    }

    @WriteCache(value = "comment")
    @Override
    public Integer deleteComment(Integer id) {
        return commentRepository.deleteSingleComment(id);
    }

    @Override
    public Integer subLikeNumber(Integer commentId){
        return commentRepository.subLikeNumber(commentId);
    }
    @Override
    public Integer addLikeNumber(Integer commentId){
        return commentRepository.addLikeNumber(commentId);
    }
}
