package com.springmvc.repository.impl;

import com.springmvc.pojo.Thuoc;
import com.springmvc.repository.Thuocrepository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ThuocRepositoryImpl implements Thuocrepository {
    @Autowired
    private LocalSessionFactoryBean factoryBean;


    @Override
    public List<Thuoc> getListThuoc() {
        Session s = factoryBean.getObject().getCurrentSession();
        Query q = s.createQuery("from Thuoc ");
        return q.getResultList();
    }

    @Override
    public Thuoc createThuoc(Thuoc thuoc) {
        Session s = factoryBean.getObject().getCurrentSession();
        s.save(thuoc);
        return thuoc;
    }
}
