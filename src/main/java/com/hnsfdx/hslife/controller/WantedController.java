package com.hnsfdx.hslife.controller;

import com.hnsfdx.hslife.pojo.Wanted;
import com.hnsfdx.hslife.service.WantedService;
import com.hnsfdx.hslife.util.PageUtil;
import com.hnsfdx.hslife.util.ResponseTypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/wanted")
public class WantedController {

    private WantedService wantedService;

    @Autowired
    public WantedController(WantedService wantedService) {
        this.wantedService = wantedService;
    }

    @PostMapping("/addwanted")
    public Map<String, Object> addWanted(@RequestBody Wanted wanted) {
        Integer result = wantedService.addWanted(wanted);
        Map<String, Object> res =ResponseTypeUtil.createDataOpResponse(result, wanted.getId());
        return res;
    }
    //找到所有悬赏信息
    @GetMapping("/getallwanteds")
    public Map<String,Object> getAllWanteds(@RequestParam("page") Integer page) {
        List<Wanted> wantedList = wantedService.getAllWanteds((page - 1) * PageUtil.PAGESIZE, PageUtil.PAGESIZE);
        Map<String,Object> forRet =  ResponseTypeUtil.createSucResponse();
        forRet.put("data",wantedList);
        return forRet;
    }
    //找到某个接受人接受的所有悬赏信息
    @GetMapping("/getallwantedsbyrid")
    public Map<String,Object> getAllWantedsByRId(@RequestParam("openId") String openId) {
        List<Wanted> wantedList = wantedService.getAllWantedsByRecipientOpenId(openId);
        Map<String,Object> forRet =  ResponseTypeUtil.createSucResponse();
        forRet.put("data",wantedList);
        return forRet;
    }
    //找到某个人发布的所有悬赏信息
    @GetMapping("/getallwantedsbyaid")
    public Map<String,Object> getAllWantedsByAId(@RequestParam("openId") String openId) {
        List<Wanted> wantedList = wantedService.getAllWantedsByAuthorOpenId(openId);
        Map<String,Object> forRet =  ResponseTypeUtil.createSucResponse();
        forRet.put("data",wantedList);
        return forRet;
    }
    //找到所有的某个状态的悬赏信息（急/已解决/未解决）
    @GetMapping("/getallwantedsbys")
    public Map<String,Object> getAllWantedsByS(@RequestParam("status") Integer status, @RequestParam("page") Integer page) {
        List<Wanted> wantedList = wantedService.getAllWantedsByStatus(status, (page - 1) * PageUtil.PAGESIZE, PageUtil.PAGESIZE);
        Map<String,Object> forRet =  ResponseTypeUtil.createSucResponse();
        forRet.put("data",wantedList);
        return forRet;
    }
    //找到搜索的类似标题的悬赏信息
    @GetMapping("/getallwantedsbyt")
    public Map<String,Object> getAllWantedsByT(@RequestParam("title") String title, @RequestParam("page") Integer page) {
        List<Wanted> wantedList = wantedService.getAllWantedsByTitle(title, (page - 1) * PageUtil.PAGESIZE, PageUtil.PAGESIZE);
        Map<String,Object> forRet =  ResponseTypeUtil.createSucResponse();
        forRet.put("data",wantedList);
        return forRet;
    }
}
