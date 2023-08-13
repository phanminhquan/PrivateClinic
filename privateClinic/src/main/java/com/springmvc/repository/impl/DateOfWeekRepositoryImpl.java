package com.springmvc.repository.impl;

import com.springmvc.pojo.DateOfWeek;
import com.springmvc.repository.DateOfWeekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class DateOfWeekRepositoryImpl implements DateOfWeekRepository {
    @Autowired
    private LocalSessionFactoryBean factory;
    @Override
    public List<DateOfWeek> listDateOFWeek() {
        return factory.getObject().getCurrentSession().createQuery("FROM DateOfWeek ").getResultList();
    }

    @Override
    public DateOfWeek getDateOfWeekByID(int id) {
        return factory.getObject().getCurrentSession().get(DateOfWeek.class,id);
    }
}
