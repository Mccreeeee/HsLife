package com.hnsfdx.hslife.pojo;

public class CommentLikeRecord {
    public CommentLikeRecord(){

    }
    public CommentLikeRecord(Integer commentId, String user){
        this.commentId=commentId;
        this.user=user;
    }
    private String user;
    private Integer commentId;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }


}
