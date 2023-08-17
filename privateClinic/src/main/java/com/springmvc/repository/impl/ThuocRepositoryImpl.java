package com.springmvc.repository.impl;

import com.springmvc.pojo.Thuoc;
import com.springmvc.repository.Thuocrepository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class ThuocRepositoryImpl implements Thuocrepository {
    @Autowired
    private LocalSessionFactoryBean factoryBean;

    @Autowired
    private Environment env;

    @Override
    public List<Thuoc> getListThuoc(Map<String, String> params) {
        Session s = factoryBean.getObject().getCurrentSession();
        Query q = s.createQuery("from Thuoc ");
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
    public Thuoc addOrUpdateThuoc(Thuoc thuoc) {
        Session s = this.factoryBean.getObject().getCurrentSession();
        if (thuoc.getMaThuoc() == null) {
            s.save(thuoc);
        } else {
            s.update(thuoc);
        }
        return thuoc;
    }


    @Override
    public Thuoc getThuocById(long id) {
        Session s = factoryBean.getObject().getCurrentSession();
        return s.get(Thuoc.class, id);
    }

    @Override
    public void deleteThuoc(long id) {
        Session s = factoryBean.getObject().getCurrentSession();
        s.delete(s.get(Thuoc.class, id));
    }

    @Override
    public List<Thuoc> searchThuoc(String kw) {
        Session s = this.factoryBean.getObject().getCurrentSession();
        Query q = s.createQuery("from Thuoc where tenThuoc like :ten");
        q.setParameter("ten", "%" + kw.toUpperCase() + "%");
        return q.getResultList();
    }

    @Override
    public Long countPromotion(long in) {
        Session s = this.factoryBean.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT Count(*) FROM Thuoc");
        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public List<Object[]> getListThuocByPK(long id) {
        Session s = factoryBean.getObject().getCurrentSession();
        Query q = s.createQuery("select t.tenThuoc,t.donVi,pt.soLuong,pt.cachDung from PhieuThuoc pt join Thuoc t on t.id = pt.maThuoc.id where pt.maPK.maPK = :id");
        q.setParameter("id", id);
        return q.getResultList();
    }

    @Override
    public List<Thuoc> getListThuocByPhieuKham(long id) {
        Session s = factoryBean.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT t from  Thuoc t join PhieuThuoc pt on t.id =pt.maThuoc.id " +
                "join PhieuKham pk on pk.maPK = pt.maPK.maPK where pk.maPK = :id");
        q.setParameter("id",id);
        return q.getResultList();
    }

    @Override
    public List<Object[]> listCustomUIByPhieuKham(long id) {
        Session s= factoryBean.getObject().getCurrentSession();
        Query q =  s.createQuery("SELECT t.maThuoc,t.tenThuoc,pt.soLuong,pt.cachDung from  Thuoc t join PhieuThuoc pt on t.id =pt.maThuoc.id " +
                "join PhieuKham pk on pk.maPK = pt.maPK.maPK where pk.maPK = :id");
        q.setParameter("id",id);
        return q.getResultList();
    }
}
