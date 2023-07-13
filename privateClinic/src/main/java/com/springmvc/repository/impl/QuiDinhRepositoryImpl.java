package com.springmvc.repository.impl;

import com.springmvc.pojo.QuiDinh;
import com.springmvc.repository.QuiDinhRepository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
@PropertySource("classpath:configs.properties")
public class QuiDinhRepositoryImpl implements QuiDinhRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Override
    public List<QuiDinh> getQuiDinhs() {
        Session session = this.factory.getObject().getCurrentSession();
        Query q = session.createQuery("From QuiDinh ");
        List<QuiDinh> list = q.getResultList();
        return  list;
    }
}
