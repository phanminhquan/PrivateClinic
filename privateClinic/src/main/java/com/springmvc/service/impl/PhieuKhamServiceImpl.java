package com.springmvc.service.impl;

import com.springmvc.repository.PhieuKhamRepository;
import com.springmvc.service.PhieuKhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PhieuKhamServiceImpl implements PhieuKhamService {


    @Autowired
    PhieuKhamRepository phieuKhamRepository;
    @Override
    public List<Object[]> getListObjUI(Map<String,String>map) {
        return phieuKhamRepository.listObjPayUI(map);
    }

}
