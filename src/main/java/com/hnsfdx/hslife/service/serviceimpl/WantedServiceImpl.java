package com.hnsfdx.hslife.service.serviceimpl;

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
    @Override
    public void addWanted(Wanted wanted) {
        wantedRepository.insertOneWanted(wanted);
    }

    @Override
    public List<Wanted> getAllWanteds(Integer offset) {
        return wantedRepository.findAllWanteds(offset);
    }

    @Override
    public List<Wanted> getAllWantedsByRecipientOpenId(String openId) {
        return wantedRepository.findAllWantedsByRecipientOpenId(openId);
    }

    @Override
    public List<Wanted> getAllWantedsByAuthorOpenId(String openId) {
        return wantedRepository.findAllWantedsByAuthorOpenId(openId);
    }

    @Override
    public List<Wanted> getAllWantedsByStatus(Integer status, Integer offset) {
        return wantedRepository.findAllWantedsByStatus(status, offset);
    }

    @Override
    public List<Wanted> getAllWantedsByTitle(String title, Integer offset) {
        return wantedRepository.findAllWantedsByTitle(title, offset);
    }
}
