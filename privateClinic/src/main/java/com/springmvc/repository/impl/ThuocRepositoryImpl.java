package com.springmvc.repository.impl;

import com.springmvc.dto.ThuocDTO;
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

    @Override
    public Thuoc updateThuoc(Thuoc thuoc) {
        Session s = factoryBean.getObject().getCurrentSession();
        Thuoc t = s.get(Thuoc.class,thuoc.getMaThuoc());
        t.setTenThuoc(thuoc.getTenThuoc());
        t.setGiaBan(thuoc.getGiaBan());
        t.setDonVi(thuoc.getDonVi());
        t.setHinhAnh(thuoc.getHinhAnh());
        t.setIsActive(thuoc.getIsActive());
        t.setMoTa(thuoc.getMoTa());
        t.setSoLuong(thuoc.getSoLuong());
        s.update(t);
        return t;
    }

    @Override
    public Thuoc getThuocById(long id) {
        Session s = factoryBean.getObject().getCurrentSession();
        return s.get(Thuoc.class,id);
    }

    @Override
    public void deleteThuoc(long id) {
        Session s = factoryBean.getObject().getCurrentSession();
        s.delete(s.get(Thuoc.class,id));
    }
}
