package com.hnsfdx.hslife.service;

import com.hnsfdx.hslife.pojo.Wanted;

import java.util.List;

public interface WantedService {
    void addWanted(Wanted wanted);
    //找到所有悬赏信息
    List<Wanted> getAllWanteds();
    //找到某个接受人接受的所有悬赏信息
    List<Wanted> getAllWantedsByRecipientOpenId(String openId);
    //找到某个人发布的所有悬赏信息
    List<Wanted> getAllWantedsByAuthorOpenId(String openId);
    //找到所有的某个状态的悬赏信息（急/已解决/未解决）
    List<Wanted> getAllWantedsByStatus(Integer status);
    //找到搜索的类似标题的悬赏信息
    List<Wanted> getAllWantedsByTitle(String title);
}
