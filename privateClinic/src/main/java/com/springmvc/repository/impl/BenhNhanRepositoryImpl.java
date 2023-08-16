package com.springmvc.repository.impl;

import com.springmvc.pojo.BenhNhan;
import com.springmvc.repository.BenhNhanRepository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Repository
@Transactional
public class BenhNhanRepositoryImpl implements BenhNhanRepository {
    @Autowired
    private LocalSessionFactoryBean factory;
    @Override
    public BenhNhan getBenhNhanByID(long id) {
        return factory.getObject().getCurrentSession().get(BenhNhan.class,id);
    }

    @Override
    public List<BenhNhan> SearchBN(String kw) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("from BenhNhan where hoTen like :ten");
        q.setParameter("ten","%" + kw.toUpperCase() + "%");
        return q.getResultList();
    }

    @Override
    public List<BenhNhan> getALL(Map<String,String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("from BenhNhan");
        return q.getResultList();
    }
}
