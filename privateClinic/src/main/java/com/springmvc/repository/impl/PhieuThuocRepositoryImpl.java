package com.springmvc.repository.impl;

import com.springmvc.pojo.PhieuThuoc;
import com.springmvc.repository.PhieuThuocRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;
@Repository
@Transactional
public class PhieuThuocRepositoryImpl implements PhieuThuocRepository {

    @Autowired
    private LocalSessionFactoryBean factoryBean;

    @Override
    public List<PhieuThuoc> getListPT() {
        Session s = factoryBean.getObject().getCurrentSession();
        Query q = s.createQuery("from PhieuThuoc");
        return q.getResultList();
    }

    @Override
    public PhieuThuoc addPhieuThuoc(PhieuThuoc phieuThuoc) {
        Session s = factoryBean.getObject().getCurrentSession();
        if (phieuThuoc.getMaPKThuoc() == null)
            s.save(phieuThuoc);
        else
            s.update(phieuThuoc);
        return phieuThuoc;
    }

}
