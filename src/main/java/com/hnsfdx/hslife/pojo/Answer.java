package com.hnsfdx.hslife.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class Answer {
    private Integer id,entertainmentid;
    private String content,reviewer;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp publishdate;

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

    public Timestamp getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Timestamp publishdate) {
        this.publishdate = publishdate;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", entertainmentid=" + entertainmentid +
                ", content='" + content + '\'' +
                ", reviewer='" + reviewer + '\'' +
                ", publishdate=" + publishdate +
                '}';
    }
}
