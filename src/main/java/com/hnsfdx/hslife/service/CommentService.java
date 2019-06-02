package com.hnsfdx.hslife.service;

import com.hnsfdx.hslife.pojo.Comment;

import java.util.List;

public interface CommentService {
    void addComment(Comment comment);
    //找到某个疑问下的所有评论
    List<Comment> getAllCommentsByQuesionId(Integer questionId);
    //找到某个疑问下点赞数最高的3条评论
    List<Comment> getAllCommentsByQuesionIdMost3(Integer questionId);
    //找到某个疑问下按最新时间排序的所有评论
    List<Comment> getAllCommentsByQuesionIdOrdered(Integer questionId);
    //找到“我”评论过的所有疑问id
    List<Integer> getAllCommentsByReviewerOpenId(String openId);
}
