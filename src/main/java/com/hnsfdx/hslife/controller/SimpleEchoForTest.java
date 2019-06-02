package com.hnsfdx.hslife.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("EchoTest")
public class SimpleEchoForTest {
    @GetMapping("echo")
    public String echo(@RequestParam("msg") String msg){
        return msg;
    }
}
