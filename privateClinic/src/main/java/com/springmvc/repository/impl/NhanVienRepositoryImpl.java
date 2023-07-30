package com.springmvc.repository.impl;

import com.springmvc.pojo.NhanVien;
import com.springmvc.pojo.UserRole;
import com.springmvc.repository.NhanVienRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;


@Repository
@Transactional
public class NhanVienRepositoryImpl implements NhanVienRepository {
    @Autowired
    private LocalSessionFactoryBean factory;
    @Override
    public NhanVien getNhanVienById(long id) {
        return factory.getObject().getCurrentSession().get(NhanVien.class,id);
    }

    @Override
    public List<NhanVien> getListNV() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("from NhanVien ");
        return  q.getResultList();
    }

    @Override
    public List<NhanVien> getListBS() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("from NhanVien n where n.idUser.id = :id");
        long in = 1;
        q.setParameter("id",in);
        return q.getResultList();
    }

    @Override
    public List<NhanVien> getListYT() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("from NhanVien n where n.idUser.id = :id");
        long in = 2;
        q.setParameter("id",in);
        return q.getResultList();
    }


    @Override
    public NhanVien addOrUpdateNhanVien(NhanVien nv) {
        Session s = this.factory.getObject().getCurrentSession();
            if (nv.getMaNV() == null) {
                s.save(nv);
            } else {
                s.update(nv);
            }
            return nv;
    }

    @Override
    public UserRole findUserRoleById(long id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(UserRole.class,id);
    }

    @Override
    public void deleteNhanVien(long id) {
        Session s = this.factory.getObject().getCurrentSession();
        s.delete(s.get(NhanVien.class,id));
    }
}
