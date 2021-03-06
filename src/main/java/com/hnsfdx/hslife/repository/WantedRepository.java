package com.hnsfdx.hslife.repository;

import com.hnsfdx.hslife.pojo.Wanted;

import java.util.List;

public interface WantedRepository {
    Integer insertOneWanted(Wanted wanted);

    //找到所有悬赏信息
    List<Wanted> findAllWanteds(Integer offset, Integer size);

    //所有悬赏信息的数量
    Integer countAllWanteds();

    //找到某个接受人接受的所有悬赏信息
    List<Wanted> findAllWantedsByRecipientOpenId(String openId);

    //找到某个人发布的所有悬赏信息
    List<Wanted> findAllWantedsByAuthorOpenId(String openId);

    //找到所有的某个状态的悬赏信息（急/已解决/未解决）
    List<Wanted> findAllWantedsByStatus(Integer status, Integer offset, Integer size);

    //所有的某个状态的悬赏数量
    Integer countAllWantedsByStatus(Integer status);

    //找到搜索的类似标题的悬赏信息
    List<Wanted> findAllWantedsByTitle(String title, Integer offset, Integer size);

    //所有的搜索的类似标题的悬赏的数量
    Integer countAllWantedsByTitle(String title);

    Integer updateSingleWanted(Wanted wanted);

    Integer deleteSingleWanted(Integer id);
}
