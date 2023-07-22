package com.springmvc.repository.impl;

import com.springmvc.pojo.CtDsKham;
import com.springmvc.pojo.DsKhamBenh;
import com.springmvc.repository.CtDsKhamRepository;
import com.springmvc.repository.DsKhamBenhRepository;
import com.springmvc.service.DsKhamBenhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

@Repository
public class DsKhamBenhRepositoryImpl implements DsKhamBenhRepository {
    @Autowired
    private LocalSessionFactoryBean factory;
    @Override
    public DsKhamBenh getByID(long id) {
        return factory.getObject().getCurrentSession().get(DsKhamBenh.class,id);
    }
}
