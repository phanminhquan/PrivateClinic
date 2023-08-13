package com.springmvc.repository.impl;

import com.springmvc.repository.DsKhamBenhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

@Repository
public class DsKhamBenhRepositoryImpl implements DsKhamBenhRepository {
//    @Autowired
//    private LocalSessionFactoryBean factory;
//    @Override
//    public DsKhamBenh getByID(long id) {
//        return factory.getObject().getCurrentSession().get(DsKhamBenh.class,id);
//    }
}
