package com.hnsfdx.hslife.mapper;

import com.hnsfdx.hslife.pojo.Wanted;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WantedMapper {
    @Insert("INSERT INTO wanteds(title, content, author, publishdate, value, status, recipient, imgurl1, imgurl2, imgurl3, imgurl4)" +
            "VALUES " +
            "(#{title}, #{content}, #{author}, #{publishDate}, #{value}, #{status}, #{recipient}, #{imgurl1}, #{imgurl2}, #{imgurl3}, #{imgurl4})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Integer insertOneWanted(Wanted wanted);
    //找到所有悬赏信息
    List<Wanted> findAllWanteds(@Param(value = "offset") Integer offset, @Param(value = "size") Integer size);
    //找到某个接受人接受的所有悬赏信息
    List<Wanted> findAllWantedsByRecipientOpenId(@Param(value = "openId") String openId);
    //找到某个人发布的所有悬赏信息
    List<Wanted> findAllWantedsByAuthorOpenId(@Param(value = "openId") String openId);
    //找到所有的某个状态的悬赏信息（急/已解决/未解决）
    List<Wanted> findAllWantedsByStatus(@Param(value = "status") Integer status,
                                        @Param(value = "offset") Integer offset,
                                        @Param(value = "size") Integer size);
    //找到搜索的类似标题的悬赏信息
    List<Wanted> findAllWantedsByTitle(@Param(value = "title") String title,
                                       @Param(value = "offset") Integer offset,
                                       @Param(value = "size") Integer size);
}
