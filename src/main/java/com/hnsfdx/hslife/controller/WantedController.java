package com.hnsfdx.hslife.controller;

import com.hnsfdx.hslife.pojo.Wanted;
import com.hnsfdx.hslife.service.WantedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wanted")
public class WantedController {

    private WantedService wantedService;

    @Autowired
    public WantedController(WantedService wantedService) {
        this.wantedService = wantedService;
    }

    @PostMapping("/addwanted")
    public String addWanted(Wanted wanted) {
        wantedService.addWanted(wanted);
        //需要做异常处理，后续再优化
        return "success!";
    }
    //找到所有悬赏信息
    @GetMapping("/getallwanteds")
    public List<Wanted> getAllWanteds(@RequestParam("offset") Integer offset) {
        return wantedService.getAllWanteds(offset);
    }
    //找到某个接受人接受的所有悬赏信息
    @GetMapping("/getallwantedsbyrid")
    public List<Wanted> getAllWantedsByRId(@RequestParam("openId") String openId) {
        return wantedService.getAllWantedsByRecipientOpenId(openId);
    }
    //找到某个人发布的所有悬赏信息
    @GetMapping("/getallwantedsbyaid")
    public List<Wanted> getAllWantedsByAId(@RequestParam("openId") String openId) {
        return wantedService.getAllWantedsByAuthorOpenId(openId);
    }
    //找到所有的某个状态的悬赏信息（急/已解决/未解决）
    @GetMapping("/getallwantedsbys")
    public List<Wanted> getAllWantedsByS(@RequestParam("status") Integer status, @RequestParam("offset") Integer offset) {
        return wantedService.getAllWantedsByStatus(status, offset);
    }
    //找到搜索的类似标题的悬赏信息
    @GetMapping("/getallwantedsbyt")
    public List<Wanted> getAllWantedsByT(@RequestParam("title") String title, @RequestParam("offset") Integer offset) {
        return wantedService.getAllWantedsByTitle(title, offset);
    }
}
