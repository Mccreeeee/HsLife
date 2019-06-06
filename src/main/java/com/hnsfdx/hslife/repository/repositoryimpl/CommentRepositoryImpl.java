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
    public Integer insertOneComment(Comment comment) {
        return commentMapper.insertOneComment(comment);
    }

    @Override
    public List<Comment> findAllCommentsByQuesionId(Integer questionId, Integer offset, Integer size) {
        return commentMapper.findAllCommentsByQuesionId(questionId, offset, size);
    }

    @Override
    public List<Comment> findAllCommentsByQuesionIdMost3(Integer questionId) {
        return commentMapper.findAllCommentsByQuesionIdMost3(questionId);
    }

    @Override
    public List<Integer> findAllCommentsByReviewerOpenId(String openId) {
        return commentMapper.findAllCommentsByReviewerOpenId(openId);
    }

    @Override
    public Integer updateSingleComment(Comment comment) {
        return commentMapper.updateSingleComment(comment);
    }

    @Override
    public Integer deleteSingleComment(Integer id) {
        return commentMapper.deleteSingleComment(id);
    }
}
