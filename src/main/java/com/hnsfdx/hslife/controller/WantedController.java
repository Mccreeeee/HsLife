package com.hnsfdx.hslife.controller;

import com.hnsfdx.hslife.exception.ArgsIntroduceException;
import com.hnsfdx.hslife.exception.AuthException;
import com.hnsfdx.hslife.exception.DataInsertException;
import com.hnsfdx.hslife.exception.StorageException;
import com.hnsfdx.hslife.pojo.Wanted;
import com.hnsfdx.hslife.service.WantedService;
import com.hnsfdx.hslife.util.FileUtils;
import com.hnsfdx.hslife.util.PageUtils;
import com.hnsfdx.hslife.util.ResponseTypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public Map<String, Object> addWanted(@RequestBody Wanted wanted) throws Exception {
        Integer result = wantedService.addWanted(wanted);
        Map<String, Object> res =ResponseTypeUtil.createDataOpResponse(result, wanted.getId(), new DataInsertException());
        return res;
    }
    //找到所有悬赏信息
    @GetMapping("/getallwanteds")
    public Map<String,Object> getAllWanteds(@RequestParam("page") Integer page) {
        if(page <= 0) {
            throw new ArgsIntroduceException();
        }
        List<Wanted> wantedList = wantedService.getAllWanteds((page - 1) * PageUtils.PAGESIZE, PageUtils.PAGESIZE);
        Map<String,Object> forRet =  ResponseTypeUtil.createSucResponse();
        forRet.put("data",wantedList);
        return forRet;
    }
    //悬赏信息最大页数
    @GetMapping("/getallwantedsmaxpage")
    public Map<String, Object> getAllWantedsMaxPage() {
        Integer count = wantedService.getAllWantedsCount();
        Map<String, Object> forRet = ResponseTypeUtil.createSucResponse();
        forRet.put("data", (int) Math.ceil(count * 1.0 / PageUtils.PAGESIZE));
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
        if(page <= 0) {
            throw new ArgsIntroduceException();
        }
        List<Wanted> wantedList = wantedService.getAllWantedsByStatus(status, (page - 1) * PageUtils.PAGESIZE, PageUtils.PAGESIZE);
        Map<String,Object> forRet =  ResponseTypeUtil.createSucResponse();
        forRet.put("data",wantedList);
        return forRet;
    }

    //某个状态悬赏信息的最大页数
    @GetMapping("/getallwantedsbysmaxpage")
    public Map<String, Object> getAllWantedsBySMaxPage(@RequestParam("status") Integer status) {
        Integer count = wantedService.getAllWantedsByStatusCount(status);
        Map<String, Object> forRet = ResponseTypeUtil.createSucResponse();
        forRet.put("data", (int) Math.ceil(count * 1.0 / PageUtils.PAGESIZE));
        return forRet;
    }

    //找到搜索的类似标题的悬赏信息
    @GetMapping("/getallwantedsbyt")
    public Map<String,Object> getAllWantedsByT(@RequestParam("title") String title, @RequestParam("page") Integer page) {
        if(page <= 0) {
            throw new ArgsIntroduceException();
        }
        List<Wanted> wantedList = wantedService.getAllWantedsByTitle(title, (page - 1) * PageUtils.PAGESIZE, PageUtils.PAGESIZE);
        Map<String,Object> forRet =  ResponseTypeUtil.createSucResponse();
        forRet.put("data",wantedList);
        return forRet;
    }

    //所有类似标题的悬赏信息的最大页数
    @GetMapping("/getallwantedsbytmaxpage")
    public Map<String, Object> getAllWantedsByTMaxPage(@RequestParam("title") String title) {
        Integer count = wantedService.getAllWantedsByTitleCount(title);
        Map<String, Object> forRet = ResponseTypeUtil.createSucResponse();
        forRet.put("data", (int) Math.ceil(count * 1.0 / PageUtils.PAGESIZE));
        return forRet;
    }
    @PostMapping("/updatewanted")
    public Map<String,Object> updateSingleWanted(@RequestBody Wanted wanted){
        if(wantedService.updateSingleWanted(wanted) == 1){
            return ResponseTypeUtil.createSucResponse();
        }
        else{
            return ResponseTypeUtil.createFailResponse();
        }
    }
    @GetMapping("/deletewanted")
    public Map<String,Object> deleteSingleWanted(@RequestParam(value = "id") Integer id){
        if (wantedService.deleteSingleWanted(id) == 1){
            return ResponseTypeUtil.createSucResponse();
        }
        else{
            return ResponseTypeUtil.createFailResponse();
        }
    }

    // 给出发布悬赏的人的openId和悬赏的Id以及上传的文件，将其保存在服务端，返回相对路径
    @PostMapping("/uploadimg")
    public Map<String,Object> uploadOneImage(@RequestParam("author") String author,
                                             @RequestParam("datetime") String datetime,
                                             @RequestParam("file") MultipartFile file) {
        String uploadPath = author + "/" + "wanted" + datetime + "/";
        Map<String, Object> forRet = ResponseTypeUtil.createSucResponse();
        try {
            forRet.put("data", FileUtils.uploadToServer(uploadPath, file));
        } catch (Exception e) {
            throw new StorageException();
        }
        return forRet;
    }

    // 给出发布悬赏的人的openId和悬赏的Id，删除对应相对路径下的所有文件
    @PostMapping("/deleteimg")
    public Map<String,Object> deleteOneImage(@RequestParam("author") String author,
                                             @RequestParam("datetime") String datetime) {
        String deletePath = author + "/" +  "wanted" + datetime + "/";
        Map<String, Object> forRet = ResponseTypeUtil.createSucResponse();
        try {
            FileUtils.deleteInServer(deletePath);
        } catch (Exception e) {
            throw new AuthException();
        }
        return forRet;
    }
}
