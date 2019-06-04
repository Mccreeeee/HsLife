package com.hnsfdx.hslife.controller;

import com.hnsfdx.hslife.pojo.News;
import com.hnsfdx.hslife.service.NewsService;
import com.hnsfdx.hslife.util.ResponseTypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/news")
public class NewsController {
    private NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @PostMapping("/addnews")
    public Map<String, Object> addNew(@RequestBody News oneNews) {
        Integer result = newsService.addNews(oneNews);
        Map<String, Object> res = ResponseTypeUtil.createDataOpResponse(result, oneNews.getId());
        return res;
    }

    @GetMapping("/getallnews")
    public Map<String, Object> getAllNews(@RequestParam("offset") Integer offset) {
        List<News> newsList = newsService.getAllNews(offset);
        Map<String,Object> forRet =  ResponseTypeUtil.createSucResponse();
        forRet.put("data",newsList);
        return forRet;
    }
}
