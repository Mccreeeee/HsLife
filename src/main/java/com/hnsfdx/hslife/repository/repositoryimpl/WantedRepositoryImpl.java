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
    public List<Wanted> findAllWanteds(Integer offset, Integer size) {
        return wantedMapper.findAllWanteds(offset, size);
    }

    @Override
    public Integer countAllWanteds() {
        return wantedMapper.countAllWanteds();
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
    public List<Wanted> findAllWantedsByStatus(Integer status, Integer offset, Integer size) {
        return wantedMapper.findAllWantedsByStatus(status, offset, size);
    }

    @Override
    public Integer countAllWantedsByStatus(Integer status) {
        return wantedMapper.countAllWantedsByStatus(status);
    }

    @Override
    public List<Wanted> findAllWantedsByTitle(String title, Integer offset, Integer size) {
        return wantedMapper.findAllWantedsByTitle(title, offset, size);
    }

    @Override
    public Integer countAllWantedsByTitle(String title) {
        return wantedMapper.countAllWantedsByTitle(title);
    }

    @Override
    public Integer updateSingleWanted(Wanted wanted){
        return wantedMapper.updateSingleWanted(wanted);
    }

    @Override
    public Integer deleteSingleWanted(Integer id){
        return wantedMapper.deleteSingleWanted(id);
    }
}
