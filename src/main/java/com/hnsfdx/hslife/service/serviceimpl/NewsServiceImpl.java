package com.hnsfdx.hslife.service.serviceimpl;

import com.hnsfdx.hslife.annotation.ReadCache;
import com.hnsfdx.hslife.annotation.WriteCache;
import com.hnsfdx.hslife.async.EventType;
import com.hnsfdx.hslife.pojo.News;
import com.hnsfdx.hslife.repository.NewsRepository;
import com.hnsfdx.hslife.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NewsServiceImpl implements NewsService {

    private NewsRepository newsRepository;

    @Autowired
    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }
    @WriteCache(topic = "news")
    @Override
    public Integer addNews(News oneNews) {
        return newsRepository.insertOneNews(oneNews);
    }

    @ReadCache(value = "news")
    @Override
    public List<News> getAllNews(Integer offset, Integer size) {
        return newsRepository.findAllNews(offset, size);
    }

    @Override
    public Integer getAllNewsCount() {
        return newsRepository.countAllNews();
    }
}
