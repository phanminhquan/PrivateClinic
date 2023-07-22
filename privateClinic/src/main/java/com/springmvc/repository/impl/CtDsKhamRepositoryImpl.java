package com.springmvc.repository.impl;

import com.springmvc.pojo.CtDsKham;
import com.springmvc.repository.CtDsKhamRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;


@Repository
@Transactional
public class CtDsKhamRepositoryImpl implements CtDsKhamRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Override
    public CtDsKham create(CtDsKham ctDsKham) {
        factory.getObject().getCurrentSession().save(ctDsKham);
        return ctDsKham;
    }

    @Override
    public void delete(long id) {
        Session s = factory.getObject().getCurrentSession();
        CtDsKham c = s.get(CtDsKham.class,id);
        s.delete(c);
    }

    @Override
    public CtDsKham update(CtDsKham ctDsKham) {
        Session s = factory.getObject().getCurrentSession();
        CtDsKham c = s.get(CtDsKham.class,ctDsKham.getMaCTDS());
        c.setMaBN(ctDsKham.getMaBN());
        c.setTrangthai(c.getTrangthai());
        c.setMaDS(ctDsKham.getMaDS());
        c.setMaTG(ctDsKham.getMaTG());
        s.update(c);
        return c;

    }

    @Override
    public void AcceptDanhSachKham(long id) {
        Session s = factory.getObject().getCurrentSession();
        CtDsKham c = s.get(CtDsKham.class,id);
        c.setTrangthai(false);
        s.update(c);
    }

    @Override
    public List<CtDsKham> getListCtDSKham() {
        Session s = factory.getObject().getCurrentSession();
        return s.createQuery("from CtDsKham ").getResultList();
    }

    @Override
    public CtDsKham getByID(long id) {
        return factory.getObject().getCurrentSession().get(CtDsKham.class,id);
    }
}
