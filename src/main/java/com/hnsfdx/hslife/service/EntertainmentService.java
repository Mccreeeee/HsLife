package com.hnsfdx.hslife.service;

import com.hnsfdx.hslife.pojo.Entertainment;

import java.util.List;

public interface EntertainmentService {
    void insertEntertainment(Entertainment entertainment);
    List<Entertainment> getSingleEntertainmentById(Integer id);
    List<Entertainment> getEntertainments(Integer first,Integer size);
}
