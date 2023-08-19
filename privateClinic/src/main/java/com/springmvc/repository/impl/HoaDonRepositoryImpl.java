package com.springmvc.repository.impl;

import com.springmvc.pojo.HoaDon;
import com.springmvc.repository.HoaDonRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Repository
@Transactional
public class HoaDonRepositoryImpl implements HoaDonRepository {
    @Autowired
    LocalSessionFactoryBean factory;
    @Override
    public void savaHoaDon(HoaDon hoaDon) {
        Session s = factory.getObject().getCurrentSession();
        s.save(hoaDon);
    }

    @Override
    public Set<Object> getAllYear() {
        Session s = factory.getObject().getCurrentSession();
        return new HashSet<>(s.createQuery("select year(h.createdDate) from HoaDon h").getResultList());
    }
}
