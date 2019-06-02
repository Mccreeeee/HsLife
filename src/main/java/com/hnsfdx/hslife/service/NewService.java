package com.hnsfdx.hslife.service;

import com.hnsfdx.hslife.pojo.New;

import java.util.List;

public interface NewService {
    void addNew(New oneNew);
    List<New> getAllNews(Integer offset);
}
