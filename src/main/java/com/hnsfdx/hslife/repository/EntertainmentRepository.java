package com.hnsfdx.hslife.repository;

import com.hnsfdx.hslife.pojo.Entertainment;

import java.util.List;

public interface EntertainmentRepository {
    Integer insertSingle(Entertainment entertainment);

    List<Entertainment> findEntertainmentById(Integer id);

    List<Entertainment> findEntertainments(Integer firstIndex, Integer size);

    Integer countEntertainmentsNumber();

    String findRightAnswerById(Integer id);
}
