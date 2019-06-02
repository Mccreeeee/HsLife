package com.hnsfdx.hslife.service.serviceimpl;

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
    @Override
    public void addNew(News oneNews) {
        newsRepository.insertOneNew(oneNews);
    }

    @Override
    public List<News> getAllNews(Integer offset) {
        return newsRepository.findAllNews(offset);
    }
}
