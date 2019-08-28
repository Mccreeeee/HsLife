package com.hnsfdx.hslife.controller;

import com.alibaba.fastjson.JSON;
import com.hnsfdx.hslife.annotation.ReadCache;
import com.hnsfdx.hslife.pojo.User;
import com.hnsfdx.hslife.service.UserService;
import com.hnsfdx.hslife.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("EchoTest")
public class SimpleEchoForTest {
    @Autowired
    private UserService userService;
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
    @PostMapping("/delfile")
    public String testFile2() {
        FileUtils.deleteInServer("rid_is_1/qid_is_2/");
        return "sssss";
    }


    @GetMapping("/json")
    public String jsonstring() {
        String json = JSON.toJSONString(userService.getUser("00123qhl2oYKyD0wyWhl2s3yhl223qhF"));
        return json;
    }

    @ReadCache()
    @GetMapping("/object")
    public User userList() {
        return userService.getUser("00123qhl2oYKyD0wyWhl2s3yhl223qhF");
    }
}
