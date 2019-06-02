package com.hnsfdx.hslife.pojo;

import java.sql.Timestamp;

public class Question {
    private Integer id;

    private String title;

    private String content;

    private String author;

    private Timestamp publishDate;

    private String imglurl1;

    private String imglurl2;

    private String imglurl3;

    private String imglurl4;

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

    public String getImglurl1() {
        return imglurl1;
    }

    public void setImglurl1(String imglurl1) {
        this.imglurl1 = imglurl1;
    }

    public String getImglurl2() {
        return imglurl2;
    }

    public void setImglurl2(String imglurl2) {
        this.imglurl2 = imglurl2;
    }

    public String getImglurl3() {
        return imglurl3;
    }

    public void setImglurl3(String imglurl3) {
        this.imglurl3 = imglurl3;
    }

    public String getImglurl4() {
        return imglurl4;
    }

    public void setImglurl4(String imglurl4) {
        this.imglurl4 = imglurl4;
    }
}
