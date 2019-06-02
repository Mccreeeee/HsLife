package com.hnsfdx.hslife.repository.repositoryimpl;

import com.hnsfdx.hslife.mapper.NewMapper;
import com.hnsfdx.hslife.pojo.New;
import com.hnsfdx.hslife.repository.NewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class NewRepositoryImpl implements NewRepository {

    private final NewMapper newMapper;

    @Autowired
    public NewRepositoryImpl(NewMapper newMapper) {
        this.newMapper = newMapper;
    }

    @Override
    public void insertOneNew(New oneNew) {
        newMapper.insertOneNew(oneNew);
    }

    @Override
    public List<New> findAllNews() {
        return newMapper.findAllNews();
    }
}
