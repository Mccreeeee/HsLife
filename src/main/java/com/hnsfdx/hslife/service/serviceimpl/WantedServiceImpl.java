package com.hnsfdx.hslife.service.serviceimpl;

import com.hnsfdx.hslife.annotation.ReadCache;
import com.hnsfdx.hslife.annotation.WriteCache;
import com.hnsfdx.hslife.async.EventType;
import com.hnsfdx.hslife.pojo.Wanted;
import com.hnsfdx.hslife.repository.WantedRepository;
import com.hnsfdx.hslife.service.WantedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WantedServiceImpl implements WantedService {

    private WantedRepository wantedRepository;

    @Autowired
    public WantedServiceImpl(WantedRepository wantedRepository) {
        this.wantedRepository = wantedRepository;
    }

    @WriteCache(topic = "wanted")
    @Override
    public Integer addWanted(Wanted wanted) {
        return wantedRepository.insertOneWanted(wanted);
    }

    @ReadCache(value = "wanted")
    @Override
    public List<Wanted> getAllWanteds(Integer offset, Integer size) {
        return wantedRepository.findAllWanteds(offset, size);
    }

    @Override
    public Integer getAllWantedsCount() {
        return wantedRepository.countAllWanteds();
    }

    @ReadCache(value = "wanted")
    @Override
    public List<Wanted> getAllWantedsByRecipientOpenId(String openId) {
        return wantedRepository.findAllWantedsByRecipientOpenId(openId);
    }

    @ReadCache(value = "wanted")
    @Override
    public List<Wanted> getAllWantedsByAuthorOpenId(String openId) {
        return wantedRepository.findAllWantedsByAuthorOpenId(openId);
    }

    @ReadCache(value = "wanted")
    @Override
    public List<Wanted> getAllWantedsByStatus(Integer status, Integer offset, Integer size) {
        return wantedRepository.findAllWantedsByStatus(status, offset, size);
    }

    @Override
    public Integer getAllWantedsByStatusCount(Integer status) {
        return wantedRepository.countAllWantedsByStatus(status);
    }

    @ReadCache(value = "wanted")
    @Override
    public List<Wanted> getAllWantedsByTitle(String title, Integer offset, Integer size) {
        return wantedRepository.findAllWantedsByTitle(title, offset, size);
    }

    @Override
    public Integer getAllWantedsByTitleCount(String title) {
        return wantedRepository.countAllWantedsByTitle(title);
    }

    @WriteCache(topic = "wanted")
    @Override
    public Integer updateSingleWanted(Wanted wanted){
        return wantedRepository.updateSingleWanted(wanted);
    }

    @WriteCache(topic = "wanted")
    @Override
    public Integer deleteSingleWanted(Integer id){
        return wantedRepository.deleteSingleWanted(id);
    }
}
