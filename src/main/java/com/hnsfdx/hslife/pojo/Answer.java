package com.hnsfdx.hslife.pojo;

import java.sql.Date;

public class Answer {
    private Integer id,entertainmentid;
    String content,reviewer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEntertainmentid() {
        return entertainmentid;
    }

    public void setEntertainmentid(Integer entertainmentid) {
        this.entertainmentid = entertainmentid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public Date getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate;
    }

    Date publishdate;
}
