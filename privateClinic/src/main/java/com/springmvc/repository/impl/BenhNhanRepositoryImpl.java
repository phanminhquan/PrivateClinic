package com.springmvc.repository.impl;

import com.springmvc.pojo.BenhNhan;
import com.springmvc.repository.BenhNhanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;


@Repository
public class BenhNhanRepositoryImpl implements BenhNhanRepository {
    @Autowired
    private LocalSessionFactoryBean factory;
    @Override
    public BenhNhan getBenhNhanByID(long id) {
        return factory.getObject().getCurrentSession().get(BenhNhan.class,id);
    }
}
