package com.hnsfdx.hslife.controller;

import com.hnsfdx.hslife.pojo.Entertainment;
import com.hnsfdx.hslife.service.EntertainmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

@RestController
@RequestMapping("/Entertainments")
public class EntertainmentsController {
    private EntertainmentService entertainmentService;

    @Autowired
    public EntertainmentsController(EntertainmentService entertainmentService){
        this.entertainmentService=entertainmentService;
    }

    @PostMapping("addEntertainment")
    public String addEntertainment(@RequestBody Entertainment entertainment){
        try{
            entertainmentService.insertEntertainment(entertainment);
            return "success";
        }
        catch (Exception e){
            Logger.getLogger("Runtime.Entertainments").info(String.format("添加娱乐讨论失败:%s",e.getMessage()));
            return "fail";
        }
    }

}
