package com.hnsfdx.hslife.controller;

import com.hnsfdx.hslife.pojo.News;
import com.hnsfdx.hslife.service.NewsService;
import com.hnsfdx.hslife.util.ResponseTypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/new")
public class NewsController {
    private NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @PostMapping("/addnew")
    public String addNew(@RequestBody News oneNews) {
        newsService.addNew(oneNews);
        //此处要加异常处理，后续再进行优化
        return ResponseTypeUtil.BOOLEAN_SUC;
    }

    @GetMapping("/getallnews")
    public List<News> getAllNews(@RequestParam("offset") Integer offset) {
        return newsService.getAllNews(offset);
    }
}
