package com.hnsfdx.hslife.controller;

import com.hnsfdx.hslife.pojo.New;
import com.hnsfdx.hslife.service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/new")
public class NewController {
    private NewService newService;

    @Autowired
    public NewController(NewService newService) {
        this.newService = newService;
    }

    @PostMapping("/addnew")
    public String addNew(@RequestBody New oneNew) {
        newService.addNew(oneNew);
        //此处要加异常处理，后续再进行优化
        return "success!";
    }

    @GetMapping("/getallnews")
    public List<New> getAllNews(@RequestParam("offset") Integer offset) {
        return newService.getAllNews(offset);
    }
}
