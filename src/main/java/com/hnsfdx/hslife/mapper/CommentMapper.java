package com.hnsfdx.hslife.mapper;

import com.hnsfdx.hslife.pojo.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {
    @Insert("INSERT INTO comments(questionid, content, reviewer, publishdate, likenum)" +
            "VALUES " +
            "(#{questionId}, #{content}, #{reviewer}, #{publishDate}, #{likeNum})")
    void insertOneComment(Comment comment);
    //找到某个疑问下的所有评论
    List<Comment> findAllCommentsByQuesionId(@Param(value = "questionId") Integer questionId);
    //找到某个疑问下点赞数最高的3条评论
    List<Comment> findAllCommentsByQuesionIdMost3(@Param(value = "questionId") Integer questionId);
    //找到某个疑问下按最新时间排序的所有评论
    List<Comment> findAllCommentsByQuesionIdOrdered(@Param(value = "questionId") Integer questionId);
    //找到“我”评论过的所有疑问id
    List<Integer> findAllCommentsByReviewerOpenId(@Param(value = "openId") String openId);
}
