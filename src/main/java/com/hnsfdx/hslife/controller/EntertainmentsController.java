package com.hnsfdx.hslife.controller;

import com.hnsfdx.hslife.pojo.Entertainment;
import com.hnsfdx.hslife.service.EntertainmentService;
import com.hnsfdx.hslife.util.ResponseTypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Entertainments")
public class EntertainmentsController {
    private EntertainmentService entertainmentService;

    @Autowired
    public EntertainmentsController(EntertainmentService entertainmentService) {
        this.entertainmentService = entertainmentService;
    }

    @PostMapping("/addEntertainment")
    public Map<String,Object> addEntertainment(@RequestBody Entertainment entertainment) {
        Integer lastInsertId = entertainmentService.insertEntertainment(entertainment);
        Map<String,Object> res =  ResponseTypeUtil.createSucResponse();
        res.put("data",entertainment.getId());
        return res;
    }
    @PostMapping("/findEntertainmentById")
    public Entertainment findEntertainmentById(@RequestParam("id") Integer id){
        List<Entertainment> obtained = entertainmentService.getSingleEntertainmentById(id);
        if(obtained.size()==0){
            return null;
        }
        return obtained.get(0);
    }
}
