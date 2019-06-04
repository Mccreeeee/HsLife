package com.hnsfdx.hslife.repository;

import com.hnsfdx.hslife.pojo.News;

import java.util.List;

public interface NewsRepository {
    Integer insertOneNews(News oneNews);

    List<News> findAllNews(Integer offset);
}
