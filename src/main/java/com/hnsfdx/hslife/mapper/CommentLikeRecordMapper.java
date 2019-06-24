package com.hnsfdx.hslife.mapper;

import com.hnsfdx.hslife.pojo.Answer;
import com.hnsfdx.hslife.pojo.CommentLikeRecord;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CommentLikeRecordMapper{
    @Insert("insert into CommentLikeRecord(commentId,user) " +
            "VALUES" +
            "(#{commentId},#{user})")
    Integer insertIntoCommnentLikeRecord(CommentLikeRecord commentLikeRecord);

    @Delete("DELETE FROM CommentLikeRecord where commentId = #{commentId} and user = #{user}")
    Integer deleteCommentLikeRecord(CommentLikeRecord commentLikeRecord);
}
