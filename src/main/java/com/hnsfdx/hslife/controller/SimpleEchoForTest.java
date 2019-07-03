package com.hnsfdx.hslife.controller;

import com.hnsfdx.hslife.util.FileUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    @PostMapping("/file")
    public String testFile(@RequestParam("file") MultipartFile file) {
        FileUtils.uploadToServer("rid_is_1/qid_is_2/", file);
        return "sssss";
    }
}
