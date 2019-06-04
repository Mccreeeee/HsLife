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
    public Integer insertOneWanted(Wanted wanted) {
        return wantedMapper.insertOneWanted(wanted);
    }

    @Override
    public List<Wanted> findAllWanteds(Integer offset) {
        return wantedMapper.findAllWanteds(offset);
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
    public List<Wanted> findAllWantedsByStatus(Integer status, Integer offset) {
        return wantedMapper.findAllWantedsByStatus(status, offset);
    }

    @Override
    public List<Wanted> findAllWantedsByTitle(String title, Integer offset) {
        return wantedMapper.findAllWantedsByTitle(title, offset);
    }
}
