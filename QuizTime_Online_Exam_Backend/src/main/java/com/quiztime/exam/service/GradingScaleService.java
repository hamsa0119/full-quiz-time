package com.quiztime.exam.service;

import com.quiztime.exam.model.GradingScale;
import com.quiztime.exam.repository.GradingScaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradingScaleService {

    @Autowired
    private GradingScaleRepository repository;

    public List<GradingScale> getAllScales() {
        return repository.findAll();
    }

    public List<GradingScale> saveAllScales(List<GradingScale> scales) {
        repository.deleteAll();
        return repository.saveAll(scales);
    }
}
