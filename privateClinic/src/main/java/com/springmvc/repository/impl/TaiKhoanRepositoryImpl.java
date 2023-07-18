package com.springmvc.repository.impl;

import com.springmvc.pojo.TaiKhoan;
import com.springmvc.repository.TaiKhoanRepository;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;


@Repository
@Transactional
public class TaiKhoanRepositoryImpl implements TaiKhoanRepository {
    @Autowired
    private LocalSessionFactoryBean factory;
    @Override
    public boolean addTaiKhoan(TaiKhoan taiKhoan) {
        return false;
    }

    @Override
    public List<TaiKhoan> getListTaiKhoan(String name) {
        Session session = factory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TaiKhoan> query = builder.createQuery(TaiKhoan.class);
        Root root = query.from(TaiKhoan.class);
        query = query.select(root);

        if(!name.isEmpty()){
            Predicate p = builder.equal(root.get("username").as(String.class),name.trim());
            query = query.where(p);
        }

        Query q = session.createQuery(query);
        return q.getResultList();
    }
}
