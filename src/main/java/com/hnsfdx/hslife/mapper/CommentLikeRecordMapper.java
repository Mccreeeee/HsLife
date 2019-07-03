package com.hnsfdx.hslife.mapper;

import com.hnsfdx.hslife.pojo.Answer;
import com.hnsfdx.hslife.pojo.CommentLikeRecord;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Set;

@Mapper
public interface CommentLikeRecordMapper{
    @Insert("insert into CommentLikeRecord(commentId,user) " +
            "VALUES" +
            "(#{commentId},#{user})")
    Integer insertIntoCommnentLikeRecord(CommentLikeRecord commentLikeRecord);

    @Delete("DELETE FROM CommentLikeRecord where commentId = #{commentId} and user = #{user}")
    Integer deleteCommentLikeRecord(CommentLikeRecord commentLikeRecord);

    /** 用户oid在Commentids中点了哪个赞
     *
     * @param oid 用户id
     * @param commentIds 评论id序列
     * @return 返回被oid点赞过的,并且在commentIds内的评论id
     */
    List<String> isLiked(@Param("oid") String oid,@Param("cids") List<String> commentIds);
}
