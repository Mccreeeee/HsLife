package com.hnsfdx.hslife.repository.repositoryimpl;

import com.hnsfdx.hslife.mapper.EntertainmentMapper;
import com.hnsfdx.hslife.pojo.Entertainment;
import com.hnsfdx.hslife.repository.EntertainmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EntertainmentRepositoryImpl implements EntertainmentRepository {
    private final EntertainmentMapper entertainmentMapper;

    @Autowired
    public EntertainmentRepositoryImpl(EntertainmentMapper entertainmentMapper) {
        this.entertainmentMapper = entertainmentMapper;
    }

    @Override
    public Integer insertSingle(Entertainment entertainment) {
        return this.entertainmentMapper.insertSingle(entertainment);
    }

    @Override
    public List<Entertainment> findEntertainmentById(Integer id) {
        return entertainmentMapper.findEntertainmentById(id);
    }

    @Override
    public List<Entertainment> findEntertainments(Integer firstIndex, Integer size) {
        return entertainmentMapper.findEntertainments(firstIndex, size);
    }

    @Override
    public Integer countEntertainmentsNumber(){
        return entertainmentMapper.countEntertainmentsNumber();
    }
}
