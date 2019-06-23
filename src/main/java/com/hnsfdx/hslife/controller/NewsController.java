package com.hnsfdx.hslife.controller;

import com.hnsfdx.hslife.exception.ArgsIntroduceException;
import com.hnsfdx.hslife.exception.DataInsertException;
import com.hnsfdx.hslife.pojo.News;
import com.hnsfdx.hslife.service.NewsService;
import com.hnsfdx.hslife.util.PageUtil;
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
    public Map<String, Object> addNew(@RequestBody News oneNews) throws Exception {
        Integer result = newsService.addNews(oneNews);
        Map<String, Object> res = ResponseTypeUtil.createDataOpResponse(result, oneNews.getId(), new DataInsertException());
        return res;
    }

    @GetMapping("/getallnews")
    public Map<String, Object> getAllNews(@RequestParam("page") Integer page) {
        if(page <= 0) {
            throw new ArgsIntroduceException();
        }
        List<News> newsList = newsService.getAllNews((page - 1) * PageUtil.PAGESIZE, PageUtil.PAGESIZE);
        Map<String,Object> forRet =  ResponseTypeUtil.createSucResponse();
        forRet.put("data",newsList);
        return forRet;
    }
    //新闻的最大页数
    @GetMapping("/getnewsmaxpage")
    public Map<String, Object> getNewsMaxPage() {
        Integer count = newsService.getAllNewsCount();
        Map<String, Object> forRet = ResponseTypeUtil.createSucResponse();
        forRet.put("data", (int) Math.ceil(count * 1.0 / PageUtil.PAGESIZE));
        return forRet;
    }
}
