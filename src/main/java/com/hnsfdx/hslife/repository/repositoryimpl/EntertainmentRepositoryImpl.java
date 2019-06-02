package com.hnsfdx.hslife.repository.repositoryimpl;

import com.hnsfdx.hslife.mapper.EntertainmentMapper;
import com.hnsfdx.hslife.pojo.Entertainment;
import com.hnsfdx.hslife.repository.EntertainmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EntertainmentRepositoryImpl implements EntertainmentRepository {
    private final EntertainmentMapper entertainmentMapper;

    @Autowired
    public EntertainmentRepositoryImpl(EntertainmentMapper entertainmentMapper) {
        this.entertainmentMapper = entertainmentMapper;
    }

    @Override
    public void insertSingle(Entertainment entertainment) {
        this.entertainmentMapper.insertSingle(entertainment);
    }

    @Override
    public List<Entertainment> findEntertainmentById(Integer id) {
        return entertainmentMapper.findEntertainmentById(id);
    }

    @Override
    public List<Entertainment> findEntertainments(Integer firstIndex, Integer size) {
        return entertainmentMapper.findEntertainments(firstIndex, size);
    }

}
