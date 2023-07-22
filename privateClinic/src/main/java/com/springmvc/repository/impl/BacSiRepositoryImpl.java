package com.springmvc.repository.impl;


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
    public NhanVien findUserById(Long id) {
        Session s = factory.getObject().getCurrentSession();
        return s.get(NhanVien.class,id);
    }

    @Override
    public BacSi createBS(BacSi bacSi) {
        Session s = factory.getObject().getCurrentSession();
        s.save(bacSi);
        return bacSi;
    }

    @Override
    public void deleteBS(Long id) {
        Session s = factory.getObject().getCurrentSession();
        s.delete(s.get(BacSi.class,id));
    }

    @Override
    public BacSi findBacSiById(Long id) {
        BacSi bs = new BacSi();
        Session s = factory.getObject().getCurrentSession();
        bs = s.get(BacSi.class,id);
        return  bs;
    }

    @Override
    public BacSi updateBS(BacSi bacSi) {
        BacSi bs = new BacSi();
        Session s = factory.getObject().getCurrentSession();
        bs = s.get(BacSi.class, bacSi.getMaBS());
        bs.setChungChi(bacSi.getChungChi());
        bs.setChuyenMon(bacSi.getChuyenMon());
        s.update(bs);
        return  bs;
    }

}
