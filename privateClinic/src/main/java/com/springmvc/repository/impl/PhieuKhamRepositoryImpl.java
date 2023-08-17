package com.springmvc.repository.impl;

import com.springmvc.pojo.BenhNhan;
import com.springmvc.pojo.NhanVien;
import com.springmvc.pojo.PhieuKham;
import com.springmvc.repository.PhieuKhamRepository;
import com.springmvc.pojo.CtDsKham;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


@Repository
@Transactional
public class PhieuKhamRepositoryImpl implements PhieuKhamRepository {
    @Autowired
    private LocalSessionFactoryBean factoryBean;

    @Override
    public PhieuKham createPhieuKham(PhieuKham phieuKham) {
        Session s = factoryBean.getObject().getCurrentSession();
        s.save(phieuKham);
        return phieuKham;
    }

    @Override
    public List<PhieuKham> getlistPK() {
        Session s = factoryBean.getObject().getCurrentSession();
        Query q = s.createQuery("select p " +
                "from PhieuKham p where p.maPK not in ( " +
                "select a.maPK from PhieuKham a join PhieuThuoc b on a.maPK = b.maPK.maPK" +
                ")" + " and maPK not in(" +
                "select a.maPK from PhieuKham a join HoaDon c on a.maPK = c.maPK.maPK )");
        return q.getResultList();
    }

    @Override
    public BenhNhan getBenhNhanVById(Long id) {
        Session s = factoryBean.getObject().getCurrentSession();
        return s.get(BenhNhan.class, id);
    }

    @Override
    public PhieuKham getPKById(Long id) {
        Session s = factoryBean.getObject().getCurrentSession();
        return s.get(PhieuKham.class, id);
    }

    @Override
    public PhieuKham addOrUpdatePhieu(PhieuKham phieuKham) {
        Session s = factoryBean.getObject().getCurrentSession();
        if (phieuKham.getMaPK() == null)
            s.save(phieuKham);
        else
            s.update(phieuKham);
        return phieuKham;
    }

    @Override
    public NhanVien getNhanVienById(Long id) {
        Session s = factoryBean.getObject().getCurrentSession();
        return s.get(NhanVien.class, id);
    }

    @Override
    public PhieuKham getPhieuKhamByID(Long id) {
        return factoryBean.getObject().getCurrentSession().get(PhieuKham.class, id);
    }

    @Override
    public List<PhieuKham> getAllPhieuKham() {
        Session s = factoryBean.getObject().getCurrentSession();
        Query q = s.createQuery("from PhieuKham ");
        return q.getResultList();
    }

    @Override
    public List<PhieuKham> findPkByName(String kw) {
        Session s = factoryBean.getObject().getCurrentSession();
        Query q = s.createQuery("select a from PhieuKham a join BenhNhan b on a.maBN.maBN = b.maBN where b.hoTen like :hoten");
        q.setParameter("hoten", "%" + kw.toUpperCase() + "%");
        return q.getResultList();
    }

    @Autowired
    private SimpleDateFormat f;
    @Override
    public List<Object[]> listObjPayUI(Map<String,String> pareams) {
        Session s= factoryBean.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root rPhieuKham = q.from(PhieuKham.class);
        Root rBenhNhan = q.from(BenhNhan.class);
        q.multiselect(rPhieuKham.get("maPK"),rBenhNhan.get("hoTen"),rPhieuKham.get("ngayKham"));
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rPhieuKham.get("maBN"),rBenhNhan.get("maBN")));

        List<Long> listMaPKDaThanhToan = s.createQuery("select pk.maPK from PhieuKham pk join HoaDon hd on pk.maPK = hd.maPK.maPK")
                .getResultList();
        if (listMaPKDaThanhToan.size() !=0)
                predicates.add(b.not(rPhieuKham.get("maPK").in(listMaPKDaThanhToan)));
        String maPk = pareams.get("maPK");
        if (maPk !=null && !maPk.isEmpty()){
            predicates.add(b.equal(rPhieuKham.get("maPK"),maPk));
        }
        String hoTenBenhNhan = pareams.get("hoTen");
        if(hoTenBenhNhan != null){
            predicates.add(b.like(rBenhNhan.get("hoTen"),String.format("%%%s%%", hoTenBenhNhan)));
        }
        String date = pareams.get("date");
        if(date != null && !date.isEmpty()){
            try {
                predicates.add(b.equal(rPhieuKham.get("ngayKham"), f.parse(date)));
            } catch (ParseException ex) {
                Logger.getLogger(PhieuKham.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        q.where(predicates.toArray(Predicate[]::new));


        Query query = s.createQuery(q);
        return query.getResultList();
    }


}
