package com.hnsfdx.hslife.repository;

import com.hnsfdx.hslife.pojo.New;

import java.util.List;

public interface NewRepository {
    void insertOneNew(New oneNew);

    List<New> findAllNews(Integer offset);
}
