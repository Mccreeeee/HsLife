package com.hnsfdx.hslife.controller;

import com.alibaba.fastjson.JSONObject;
import com.hnsfdx.hslife.exception.DataInsertException;
import com.hnsfdx.hslife.pojo.User;
import com.hnsfdx.hslife.service.UserService;
import com.hnsfdx.hslife.util.MiniProgramConst;
import com.hnsfdx.hslife.util.ResponseTypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signUp")
    public Map<String, Object> login(@RequestParam("js_code") String js_code,
                                     @RequestParam("nickname") String username,
                                     @RequestParam("imageUrl") String imageUrl) {
        Map<String, Object> forRet = obtainOpenId(js_code);
        if (forRet.containsKey("errcode") && (Integer) forRet.get("errcode") != 0) {
            forRet.put("result", ResponseTypeUtil.BOOLEAN_FAIL);
        } else {
            User user = new User(js_code, username, imageUrl, 0);
            userService.tryAddUser(user);
            forRet.put("result", ResponseTypeUtil.BOOLEAN_SUC);
        }
        return forRet;
    }

    private Map<String, Object> obtainOpenId(String js_code) {
        String uri = String.format(
                "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code",
                MiniProgramConst.getMiniProgramAppId(),
                MiniProgramConst.getMiniProgramSecret(),
                js_code);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        String strbody = new RestTemplate().exchange(uri, HttpMethod.GET, entity, String.class).getBody();
        JSONObject parsed = JSONObject.parseObject(strbody);
        return (Map<String, Object>) parsed;
    }

    @PostMapping("/adduser")
    public Map<String, Object> addUser(@RequestBody User user) {
        Integer result = userService.addUser(user);
        Map<String, Object> res;
        if (result == 0) {
            throw new DataInsertException();
        } else {
            res = ResponseTypeUtil.createSucResponse();
        }
        return res;
    }

    @GetMapping("/getuser")
    public Map<String, Object> getUser(@RequestParam("openId") String openId) {
        User user = userService.getUser(openId);
        Map<String, Object> forRet = ResponseTypeUtil.createSucResponse();
        forRet.put("data", user);
        return forRet;
    }

    @GetMapping("/test")
    public User test(String t) {
        User sss = userService.getUser(t);
        return sss;
    }
    @PostMapping("/getBatchOfUsers")
    public Map<String,Object> getBatchOfUsers(@RequestBody JSONObject jsonObject){
        List alist = (List)jsonObject.get("openIds");
        List<User> data =  userService.getBatchOfUser((List)jsonObject.get("openIds"));
        Map<String,Object> forRet = ResponseTypeUtil.createSucResponseWithData(data);
        return forRet;
    }
}
