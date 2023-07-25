package com.springmvc.repository.impl;

import com.springmvc.pojo.NhanVien;
import com.springmvc.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;


@Repository
public class NhanVienRepositoryImpl implements NhanVienRepository {
    @Autowired
    private LocalSessionFactoryBean factory;
    @Override
    public NhanVien getNhanVienById(long id) {
        return factory.getObject().getCurrentSession().get(NhanVien.class,id);
    }
}
