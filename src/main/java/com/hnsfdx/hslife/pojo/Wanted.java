package com.hnsfdx.hslife.pojo;

import java.sql.Timestamp;

public class Wanted {
    private Integer id;

    private String title;

    private String content;

    private String author;

    private Timestamp publishDate;

    private Float value;

    private Integer status;

    private String recipient;

    private String imgurl1;

    private String imgurl2;

    private String imgurl3;

    private String imgurl4;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Timestamp getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Timestamp publishDate) {
        this.publishDate = publishDate;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getimgurl1() {
        return imgurl1;
    }

    public void setimgurl1(String imgurl1) {
        this.imgurl1 = imgurl1;
    }

    public String getimgurl2() {
        return imgurl2;
    }

    public void setimgurl2(String imgurl2) {
        this.imgurl2 = imgurl2;
    }

    public String getimgurl3() {
        return imgurl3;
    }

    public void setimgurl3(String imgurl3) {
        this.imgurl3 = imgurl3;
    }

    public String getimgurl4() {
        return imgurl4;
    }

    public void setimgurl4(String imgurl4) {
        this.imgurl4 = imgurl4;
    }
}
