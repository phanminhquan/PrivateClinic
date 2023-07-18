package com.springmvc.service.impl;

import com.springmvc.pojo.QuiDinh;
import com.springmvc.repository.QuiDinhRepository;
import com.springmvc.service.QuiDinhService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuiDinhServiceImpl implements QuiDinhService {
    @Autowired
    QuiDinhRepository quiDinhRepository;

    @Override
    public List<QuiDinh> getQuiDinhs() {
        return quiDinhRepository.getQuiDinhs();
    }

}
