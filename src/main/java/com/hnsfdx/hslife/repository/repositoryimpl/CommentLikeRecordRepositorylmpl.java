package com.hnsfdx.hslife.repository.repositoryimpl;

import com.hnsfdx.hslife.mapper.CommentLikeRecordMapper;
import com.hnsfdx.hslife.pojo.CommentLikeRecord;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.AutomapConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentLikeRecordRepositorylmpl {
    private CommentLikeRecordMapper commentLikeRecordMapper;

    @Autowired
    public CommentLikeRecordRepositorylmpl(CommentLikeRecordMapper commentLikeRecordMapper){
        this.commentLikeRecordMapper = commentLikeRecordMapper;
    }

    public Integer insert(CommentLikeRecord commentLikeRecord){
        return commentLikeRecordMapper.insertIntoCommnentLikeRecord(commentLikeRecord);
    }
    public Integer delete(CommentLikeRecord commentLikeRecord){
        return commentLikeRecordMapper.deleteCommentLikeRecord(commentLikeRecord);
    }
    public List<String> isLike(String openid,List<String> commentIds){
        return commentLikeRecordMapper.isLiked(openid,commentIds);
    }


}
