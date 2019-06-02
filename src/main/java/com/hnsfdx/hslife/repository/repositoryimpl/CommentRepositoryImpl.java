package com.hnsfdx.hslife.repository.repositoryimpl;

import com.hnsfdx.hslife.mapper.CommentMapper;
import com.hnsfdx.hslife.pojo.Comment;
import com.hnsfdx.hslife.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentRepositoryImpl implements CommentRepository {
    private final CommentMapper commentMapper;

    @Autowired
    public CommentRepositoryImpl(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override
    public void insertOneComment(Comment comment) {
        commentMapper.insertOneComment(comment);
    }

    @Override
    public List<Comment> findAllCommentsByQuesionId(Integer questionId) {
        return commentMapper.findAllCommentsByQuesionId(questionId);
    }

    @Override
    public List<Comment> findAllCommentsByQuesionIdMost3(Integer questionId) {
        return commentMapper.findAllCommentsByQuesionIdMost3(questionId);
    }

    @Override
    public List<Comment> findAllCommentsByQuesionIdOrdered(Integer questionId) {
        return commentMapper.findAllCommentsByQuesionIdOrdered(questionId);
    }

    @Override
    public List<Integer> findAllCommentsByReviewerOpenId(String openId) {
        return commentMapper.findAllCommentsByReviewerOpenId(openId);
    }
}
