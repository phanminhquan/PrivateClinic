package com.springmvc.repository.impl;

import com.springmvc.pojo.NhanVien;
import com.springmvc.pojo.UserRole;
import com.springmvc.repository.NhanVienRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;
import java.util.Map;


@Repository
@Transactional
@PropertySource("classpath:configs.properties")
public class NhanVienRepositoryImpl implements NhanVienRepository {
    @Autowired
    private LocalSessionFactoryBean factory;

    @Autowired
    private Environment env;
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
    public List<NhanVien> getListBS(Map<String, String> params) {
        long in = 1;
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("from NhanVien n where n.idUser.id = " + in);
        if (params != null) {
            String page = params.get("page");
            if (page != null && !page.isEmpty()) {
                int p = Integer.parseInt(page);
                int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));

                q.setMaxResults(pageSize);
                q.setFirstResult((p - 1) * pageSize);
            }
        }
        return q.getResultList();
    }

    @Override
    public List<NhanVien> getListYT(Map<String, String> params) {
        long in = 2;
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("from NhanVien n where n.idUser.id = " + in);
        if (params != null) {
            String page = params.get("page");
            if (page != null && !page.isEmpty()) {
                int p = Integer.parseInt(page);
                int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));

                q.setMaxResults(pageSize);
                q.setFirstResult((p - 1) * pageSize);
            }
        }
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

    @Override
    public List<NhanVien> searchBS(String kw) {
        Session s = this.factory.getObject().getCurrentSession();
        long idbs = 1;
        Query q = s.createQuery("from NhanVien where hoTen like :hoten and idUser = " + idbs);
        q.setParameter("hoten","%" + kw.toUpperCase() + "%");
        return q.getResultList();
    }

    @Override
    public List<NhanVien> searchYT(String kw) {
        Session s = this.factory.getObject().getCurrentSession();
        long idbs = 2;
        Query q = s.createQuery("from NhanVien where hoTen like :hoten and idUser = " + idbs);
        q.setParameter("hoten","%" + kw.toUpperCase() + "%");
        return q.getResultList();
    }

    @Override
    public Long countPromotion(long in) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT Count(*) FROM NhanVien n where n.idUser.id = " + in);
        return Long.parseLong(q.getSingleResult().toString());
    }
}
