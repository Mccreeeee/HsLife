package com.hnsfdx.hslife.service.serviceimpl;

import com.hnsfdx.hslife.pojo.Entertainment;
import com.hnsfdx.hslife.repository.EntertainmentRepository;
import com.hnsfdx.hslife.repository.repositoryimpl.EntertainmentRepositoryImpl;
import com.hnsfdx.hslife.service.EntertainmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntertainmentServicelmpl implements EntertainmentService {
    private EntertainmentRepository entertainmentRepository;

    @Autowired
    public EntertainmentServicelmpl(EntertainmentRepository entertainmentRepository){
        this.entertainmentRepository=entertainmentRepository;
    }

    @Override
    public Integer countEntertainmentsNumber(){
        return this.entertainmentRepository.countEntertainmentsNumber();
    }

    @Override
    public Integer insertEntertainment(Entertainment entertainment) {
        return  entertainmentRepository.insertSingle(entertainment);
    }

    @Override
    public List<Entertainment> getSingleEntertainmentById(Integer id) {
        return entertainmentRepository.findEntertainmentById(id);
    }

    @Override
    public List<Entertainment> getEntertainments(Integer first, Integer size) {
        return entertainmentRepository.findEntertainments(first, size);
    }

    @Override
    public String getRightAnswerById(Integer id) {
        return entertainmentRepository.findRightAnswerById(id);
    }
}
