package com.hnsfdx.hslife.service.serviceimpl;

import com.hnsfdx.hslife.pojo.Entertainment;
import com.hnsfdx.hslife.repository.EntertainmentRepository;
import com.hnsfdx.hslife.service.EntertainmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntertainmentServicelmpl implements EntertainmentService {
    private EntertainmentRepository entertainmentRepository;


    @Override
    public void insertEntertainment(Entertainment entertainment) {
        entertainmentRepository.insertSingle(entertainment);
    }

    @Override
    public List<Entertainment> getSingleEntertainmentById(Integer id) {
        return entertainmentRepository.findEntertainmentById(id);
    }

    @Override
    public List<Entertainment> getEntertainments(Integer first, Integer size) {
        return entertainmentRepository.findEntertainments(first, size);
    }

}
