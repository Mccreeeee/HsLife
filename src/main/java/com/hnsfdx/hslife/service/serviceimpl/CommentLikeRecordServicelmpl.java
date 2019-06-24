package com.hnsfdx.hslife.service.serviceimpl;

import com.hnsfdx.hslife.pojo.CommentLikeRecord;
import com.hnsfdx.hslife.repository.repositoryimpl.CommentLikeRecordRepositorylmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentLikeRecordServicelmpl {
    private CommentLikeRecordRepositorylmpl commentLikeRecordRepositorylmpl;
    @Autowired
    public CommentLikeRecordServicelmpl(CommentLikeRecordRepositorylmpl commentLikeRecordServicelmpl){
        this.commentLikeRecordRepositorylmpl=commentLikeRecordServicelmpl;
    }
    public Integer insert(CommentLikeRecord commentLikeRecord){
        return commentLikeRecordRepositorylmpl.insert(commentLikeRecord);
    }
    public Integer delete(CommentLikeRecord commentLikeRecord){
        return commentLikeRecordRepositorylmpl.delete(commentLikeRecord);
    }
}
