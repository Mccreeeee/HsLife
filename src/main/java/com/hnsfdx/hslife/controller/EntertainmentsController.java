package com.hnsfdx.hslife.controller;

import com.hnsfdx.hslife.pojo.Entertainment;
import com.hnsfdx.hslife.service.EntertainmentService;
import com.hnsfdx.hslife.util.ResponseTypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Entertainments")
public class EntertainmentsController {
    private EntertainmentService entertainmentService;

    @Autowired
    public EntertainmentsController(EntertainmentService entertainmentService) {
        this.entertainmentService = entertainmentService;
    }

    @PostMapping("/addEntertainment")
    public String addEntertainment(@RequestBody Entertainment entertainment) {
        String a = entertainment.getContent();
        entertainmentService.insertEntertainment(entertainment);
        return ResponseTypeUtil.BOOLEAN_SUC;
    }
}
