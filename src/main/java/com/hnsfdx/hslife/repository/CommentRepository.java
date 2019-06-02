package com.hnsfdx.hslife.repository;

import com.hnsfdx.hslife.pojo.Comment;

import java.util.List;

public interface CommentRepository {
    void insertOneComment(Comment comment);
    //找到某个疑问下的所有评论
    List<Comment> findAllCommentsByQuesionId(Integer questionId, Integer offset);
    //找到某个疑问下点赞数最高的3条评论
    List<Comment> findAllCommentsByQuesionIdMost3(Integer questionId);
    //找到“我”评论过的所有疑问id
    List<Integer> findAllCommentsByReviewerOpenId(String openId);
}
