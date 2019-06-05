package com.hnsfdx.hslife.service.serviceimpl;

import com.hnsfdx.hslife.pojo.Wanted;
import com.hnsfdx.hslife.repository.WantedRepository;
import com.hnsfdx.hslife.service.WantedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class WantedServiceImpl implements WantedService {

    private WantedRepository wantedRepository;

    @Autowired
    public WantedServiceImpl(WantedRepository wantedRepository) {
        this.wantedRepository = wantedRepository;
    }
    @Override
    public Integer addWanted(Wanted wanted) {
        return wantedRepository.insertOneWanted(wanted);
    }

    @Override
    public List<Wanted> getAllWanteds(Integer offset, Integer size) {
        return wantedRepository.findAllWanteds(offset, size);
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
    public List<Wanted> getAllWantedsByStatus(Integer status, Integer offset, Integer size) {
        return wantedRepository.findAllWantedsByStatus(status, offset, size);
    }

    @Override
    public List<Wanted> getAllWantedsByTitle(String title, Integer offset, Integer size) {
        return wantedRepository.findAllWantedsByTitle(title, offset, size);
    }

    @Override
    public Integer updateSingleWanted(Wanted wanted){
        return wantedRepository.updateSingleWanted(wanted);
    }

    @Override
    public Integer deleteSingleWanted(Integer id){
        return wantedRepository.deleteSingleWanted(id);
    }
}
