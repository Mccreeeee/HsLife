package com.hnsfdx.hslife.mapper;

import com.hnsfdx.hslife.pojo.Answer;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AnswerMapper {
    @Insert("INSERT INTO answers(entertainmentid, content, reviewer, publishdate)" +
            "VALUES " +
            "(#{entertainmentid}, #{content}, #{reviewer}, #{publishdate})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Integer insertOneAnswer(Answer answer);

    //找到某个答题下的所有回答
    List<Answer> findAllAnswerByEntertainmentId(@Param(value = "enterId") Integer enterId,
                                          @Param(value = "lindex") Integer offset,
                                          @Param(value = "lsize") Integer size);
    //所有回答的数量
    Integer countAllAnswers(Integer enterId);
    Integer doUserAnswer(@Param("qid") Integer qid,
                         @Param("uid") String uid);
    //找到对应entertainmentId以及正确答案的回答
    List<Answer> find3FirstRightAnswer(@Param(value = "enterId") Integer enterId,
                                       @Param(value = "rightAnswer") String rightAnswer);

}
