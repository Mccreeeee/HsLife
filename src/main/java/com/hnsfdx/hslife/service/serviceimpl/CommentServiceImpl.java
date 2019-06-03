package com.hnsfdx.hslife.service.serviceimpl;

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

    @Override
    public void addComment(Comment comment) {
        commentRepository.insertOneComment(comment);
    }

    @Override
    public List<Comment> getAllCommentsByQuesionId(Integer questionId, Integer offset) {
        return commentRepository.findAllCommentsByQuesionId(questionId, offset);
    }

    @Override
    public List<Comment> getAllCommentsByQuesionIdMost3(Integer questionId) {
        return commentRepository.findAllCommentsByQuesionIdMost3(questionId);
    }

    @Override
    public List<Integer> getAllCommentsByReviewerOpenId(String openId) {
        return commentRepository.findAllCommentsByReviewerOpenId(openId);
    }
}