package com.springmvc.repository.impl;

import com.springmvc.dto.BacSiDTO;
import com.springmvc.pojo.BacSi;
import com.springmvc.pojo.NhanVien;
import com.springmvc.repository.BacSiRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class BacSiRepositoryImpl implements BacSiRepository {
    @Autowired
    private LocalSessionFactoryBean factory;
    @Override
    public List<BacSi> getListBS() {
        Session s = factory.getObject().getCurrentSession();
        Query q = s.createQuery("from BacSi");
        return q.getResultList();
    }

    @Override
    public Long findUserById() {
        NhanVien nv = new NhanVien();
        return nv.getMaNV();
    }
}
