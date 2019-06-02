package com.hnsfdx.hslife.repository.repositoryimpl;

import com.hnsfdx.hslife.mapper.WantedMapper;
import com.hnsfdx.hslife.pojo.Wanted;
import com.hnsfdx.hslife.repository.WantedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WantedRepositoryImpl implements WantedRepository {

    private final WantedMapper wantedMapper;

    @Autowired
    public WantedRepositoryImpl(WantedMapper wantedMapper) {
        this.wantedMapper = wantedMapper;
    }
    @Override
    public void insertOneWanted(Wanted wanted) {
        wantedMapper.insertOneWanted(wanted);
    }

    @Override
    public List<Wanted> findAllWanteds() {
        return wantedMapper.findAllWanteds();
    }

    @Override
    public List<Wanted> findAllWantedsByRecipientOpenId(String openId) {
        return wantedMapper.findAllWantedsByRecipientOpenId(openId);
    }

    @Override
    public List<Wanted> findAllWantedsByAuthorOpenId(String openId) {
        return wantedMapper.findAllWantedsByAuthorOpenId(openId);
    }

    @Override
    public List<Wanted> findAllWantedsByStatus(Integer status) {
        return wantedMapper.findAllWantedsByStatus(status);
    }

    @Override
    public List<Wanted> findAllWantedsByTitle(String title) {
        return wantedMapper.findAllWantedsByTitle(title);
    }
}
