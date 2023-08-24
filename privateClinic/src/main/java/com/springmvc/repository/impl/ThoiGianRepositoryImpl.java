package com.springmvc.repository.impl;

import com.springmvc.pojo.ThoiGian;
import com.springmvc.repository.ThoiGianRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ThoiGianRepositoryImpl implements ThoiGianRepsitory {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public ThoiGian getThoiGianByID(long id) {
        return factory.getObject().getCurrentSession().get(ThoiGian.class, id);
    }
}
