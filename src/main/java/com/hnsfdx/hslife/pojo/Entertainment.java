package com.hnsfdx.hslife.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import javafx.util.converter.TimeStringConverter;

import java.sql.Date;
import java.sql.Timestamp;

public class Entertainment {
    private Integer id=-1;
    private String title,imgurl1,imgurl2,imgurl3,imgurl4;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp publishdate;
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

    public String getImgurl1() {
        return imgurl1;
    }

    public void setImgurl1(String imgurl1) {
        this.imgurl1 = imgurl1;
    }

    public String getImgurl2() {
        return imgurl2;
    }

    public void setImgurl2(String imgurl2) {
        this.imgurl2 = imgurl2;
    }

    public String getImgurl3() {
        return imgurl3;
    }

    public void setImgurl3(String imgurl3) {
        this.imgurl3 = imgurl3;
    }

    public String getImgurl4() {
        return imgurl4;
    }

    public void setImgurl4(String imgurl4) {
        this.imgurl4 = imgurl4;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Timestamp publishdate) {
        this.publishdate = publishdate;
    }


    @Override
    public String toString() {
        return "Entertainment{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", imgurl1='" + imgurl1 + '\'' +
                ", imgurl2='" + imgurl2 + '\'' +
                ", imgurl3='" + imgurl3 + '\'' +
                ", imgurl4='" + imgurl4 + '\'' +
                ", content='" + content + '\'' +
                ", publishdate=" + publishdate +
                '}';
    }
}
