package com.hnsfdx.hslife.repository;

import com.hnsfdx.hslife.pojo.News;

import java.util.List;

public interface NewsRepository {
    void insertOneNew(News oneNews);

    List<News> findAllNews(Integer offset);
}
