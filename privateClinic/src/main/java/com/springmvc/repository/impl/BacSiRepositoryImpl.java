package com.springmvc.repository.impl;


import com.springmvc.customresponse.BacSiResponse;
import com.springmvc.pojo.BacSi;
import com.springmvc.pojo.NhanVien;
import com.springmvc.repository.BacSiRepository;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<Object[]> getListBacSi(Map<String, String> params) {
        Session s = factory.getObject().getCurrentSession();

        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rBacSi = q.from(BacSi.class);
        Root rUser = q.from(NhanVien.class);

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rBacSi.get("maNV"),rUser.get("maNV")));

        if(params!=null){

            String kw = params.get("kw");
            if(kw != null && !kw.isEmpty()){
                predicates.add(b.like(rUser.get("hoTen"),String.format("%%%s%%", kw)));
            }
            String chuyenMon = params.get("chuyenmon");
            if(chuyenMon !=null && !chuyenMon.isEmpty())
                predicates.add(b.equal(rBacSi.get("chuyenMon"),chuyenMon));


        }
        q.where(predicates.toArray(Predicate[]::new));
        q.multiselect(rBacSi.get("maBS"),rBacSi.get("chungChi"),
                rBacSi.get("chuyenMon"), rUser.get("hoTen"),
                rUser.get("email"),rUser.get("ngaySinh"),
                rUser.get("diaChi"),
                rUser.get("dienThoai"),
                rUser.get("hinhAnh"));
        Query query = s.createQuery(q);
        List<Object[]> l = query.getResultList();
        return query.getResultList();
    }

}
