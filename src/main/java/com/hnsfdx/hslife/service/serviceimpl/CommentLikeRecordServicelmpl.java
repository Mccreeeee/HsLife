package com.hnsfdx.hslife.service.serviceimpl;

import com.hnsfdx.hslife.annotation.ReadCache;
import com.hnsfdx.hslife.annotation.WriteCache;
import com.hnsfdx.hslife.pojo.CommentLikeRecord;
import com.hnsfdx.hslife.repository.repositoryimpl.CommentLikeRecordRepositorylmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentLikeRecordServicelmpl {
    private CommentLikeRecordRepositorylmpl commentLikeRecordRepositorylmpl;
    @Autowired
    public CommentLikeRecordServicelmpl(CommentLikeRecordRepositorylmpl commentLikeRecordServicelmpl){
        this.commentLikeRecordRepositorylmpl=commentLikeRecordServicelmpl;
    }

    @WriteCache(value = "commentlike")
    public Integer insert(CommentLikeRecord commentLikeRecord){
        return commentLikeRecordRepositorylmpl.insert(commentLikeRecord);
    }

    @WriteCache(value = "commentlike")
    public Integer delete(CommentLikeRecord commentLikeRecord){
        return commentLikeRecordRepositorylmpl.delete(commentLikeRecord);
    }

    @ReadCache(value = "commentlike")
    public List<String> isLiked(String openid,List<String> commentIds){
        return commentLikeRecordRepositorylmpl.isLike(openid,commentIds);
    }
}
