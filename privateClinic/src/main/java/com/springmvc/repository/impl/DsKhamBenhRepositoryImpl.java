package com.springmvc.repository.impl;

import com.springmvc.repository.DsKhamBenhRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
import java.util.stream.LongStream;

@Repository
public class DsKhamBenhRepositoryImpl implements DsKhamBenhRepository {
//    @Autowired
//    private LocalSessionFactoryBean factory;
//    @Override
//    public DsKhamBenh getByID(long id) {
//        return factory.getObject().getCurrentSession().get(DsKhamBenh.class,id);
//    }
}
