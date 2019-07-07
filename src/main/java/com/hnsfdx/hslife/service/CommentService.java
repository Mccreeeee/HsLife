package com.hnsfdx.hslife.service;

import com.hnsfdx.hslife.pojo.Comment;

import java.util.List;

public interface CommentService {
    Integer addComment(Comment comment);
    //找到某个疑问下的所有评论
    List<Comment> getAllCommentsByQuesionId(Integer questionId, Integer offset, Integer size);
    //所有评论的数量
    Integer getAllCommentsCount();
    //找到某个疑问下点赞数最高的3条评论
    List<Comment> getAllCommentsByQuesionIdMost3(Integer questionId);
    //找到“我”评论过的所有疑问id
    List<Integer> getAllCommentsByReviewerOpenId(String openId);
    //更新一条疑问
    Integer updateComment(Comment comment);
    //删除一条疑问
    Integer deleteComment(Integer id);
    // 取消赞之后 like-1
    Integer subLikeNumber(Integer commentId);
    // 点赞之后 like+1
    Integer addLikeNumber(Integer commentId);
}
