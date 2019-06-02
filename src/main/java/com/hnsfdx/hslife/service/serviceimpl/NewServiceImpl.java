package com.hnsfdx.hslife.service.serviceimpl;

import com.hnsfdx.hslife.pojo.New;
import com.hnsfdx.hslife.repository.NewRepository;
import com.hnsfdx.hslife.service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NewServiceImpl implements NewService {

    private NewRepository newRepository;

    @Autowired
    public NewServiceImpl(NewRepository newRepository) {
        this.newRepository = newRepository;
    }
    @Override
    public void addNew(New oneNew) {
        newRepository.insertOneNew(oneNew);
    }

    @Override
    public List<New> getAllNews() {
        return newRepository.findAllNews();
    }
}
