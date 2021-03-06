package com.hnsfdx.hslife.mapper;

import com.hnsfdx.hslife.pojo.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentMapper {
    @Insert("INSERT INTO comments(questionid, content, reviewer, publishdate, likenum)" +
            "VALUES " +
            "(#{questionId}, #{content}, #{reviewer}, #{publishDate}, #{likeNum})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Integer insertOneComment(Comment comment);
    //找到某个疑问下的所有评论
    List<Comment> findAllCommentsByQuesionId(@Param(value = "questionId") Integer questionId,
                                             @Param(value = "offset") Integer offset,
                                             @Param(value = "size") Integer size);
    @Update("UPDATE comments set likenum = likenum - 1 where id = #{commentId}")
    Integer subLikeNumber(@Param(value = "commentId") Integer commentId);
    @Update("UPDATE comments set likenum = likenum + 1 where id = #{commentId}")
    Integer addLikeNumber(@Param(value = "commentId") Integer commentId);
    //所有评论的条数
    Integer countAllComments();

    //找到某个疑问下点赞数最高的3条评论
    List<Comment> findAllCommentsByQuesionIdMost3(@Param(value = "questionId") Integer questionId);
    //找到“我”评论过的所有疑问id
    List<Integer> findAllCommentsByReviewerOpenId(@Param(value = "openId") String openId);
    Integer updateSingleComment(@Param(value = "comment") Comment comment);

    Integer deleteSingleComment(@Param(value = "id") Integer id);
}
