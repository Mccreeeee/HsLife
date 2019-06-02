package com.hnsfdx.hslife.repository.repositoryimpl;

import com.hnsfdx.hslife.mapper.NewsMapper;
import com.hnsfdx.hslife.pojo.News;
import com.hnsfdx.hslife.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class NewsRepositoryImpl implements NewsRepository {

    private final NewsMapper newsMapper;

    @Autowired
    public NewsRepositoryImpl(NewsMapper newsMapper) {
        this.newsMapper = newsMapper;
    }

    @Override
    public void insertOneNew(News oneNews) {
        newsMapper.insertOneNew(oneNews);
    }

    @Override
    public List<News> findAllNews(Integer offset) {
        return newsMapper.findAllNews(offset);
    }
}
