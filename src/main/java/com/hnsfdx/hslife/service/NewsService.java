package com.hnsfdx.hslife.service;

import com.hnsfdx.hslife.pojo.News;

import java.util.List;

public interface NewsService {
    void addNew(News oneNews);
    List<News> getAllNews(Integer offset);
}
