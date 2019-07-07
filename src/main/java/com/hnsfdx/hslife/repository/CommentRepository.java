package com.hnsfdx.hslife.repository;

import com.hnsfdx.hslife.pojo.Comment;

import java.util.List;

public interface CommentRepository {
    Integer insertOneComment(Comment comment);
    //找到某个疑问下的所有评论
    List<Comment> findAllCommentsByQuesionId(Integer questionId, Integer offset, Integer size);
    //所有评论的数量
    Integer countAllComments();
    //找到某个疑问下点赞数最高的3条评论
    List<Comment> findAllCommentsByQuesionIdMost3(Integer questionId);
    //找到“我”评论过的所有疑问id
    List<Integer> findAllCommentsByReviewerOpenId(String openId);
    //更新一条疑问
    Integer updateSingleComment(Comment comment);
    //删除一条疑问
    Integer deleteSingleComment(Integer id);
    // 取消赞 like=like-1
    public Integer subLikeNumber(Integer commentId);
    // 点赞 like = like + 1
    public Integer addLikeNumber(Integer commentId);
}
