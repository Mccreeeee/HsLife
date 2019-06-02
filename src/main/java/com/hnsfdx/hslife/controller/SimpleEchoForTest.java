package com.hnsfdx.hslife.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("EchoTest")
public class SimpleEchoForTest {
    @GetMapping("echo")
    public String echo(@RequestParam("msg") String msg){
        return msg;
    }
    @PostMapping("mapEcho")
    public String mapEcho(@RequestParam("msg") String msg){
        return msg;
    }
}
