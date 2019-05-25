package com.hnsfdx.hslife.pojo;

public class User {
    //用户的openId
    private String openId;
    //用户名
    private String userName;
    //用户分数
    private Integer score;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
