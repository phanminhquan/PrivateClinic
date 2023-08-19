package com.springmvc.repository.impl;

import com.springmvc.pojo.HoaDon;
import com.springmvc.pojo.PhieuKham;
import com.springmvc.repository.StatRepository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.*;

@Repository
@Transactional
public class StatRepositoyImpl implements StatRepository {
    @Autowired
    LocalSessionFactoryBean factory;
    @Override
    public Map<String,Float> thongKeDoanhThuTheoQuy(String year,String quy) {
        Session s =factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object> q = b.createQuery(Object.class);
        Float tongTienQuy1 = Float.valueOf(0);
        Root rHoaDon = q.from(HoaDon.class);
        if(year.equals("")){
            Query query = s.createQuery("select year(h.createdDate) from HoaDon h");
            List<Object> allYear =  query.getResultList();
            Set<Object> set = new HashSet<>(allYear);
            for(Object o : set){
                q.where(b.and(b.equal(b.function("YEAR", Integer.class, rHoaDon.get("createdDate")), Integer.parseInt(o.toString())),
                        b.equal(b.function("QUARTER", Integer.class, rHoaDon.get("createdDate")), Integer.parseInt(quy))));
                q.multiselect(b.sum(rHoaDon.get("tongTien")));
                Query query1 = s.createQuery(q);
                List<Float> total = query1.getResultList();
                Float t = total.get(0);
                if(t == null)
                   t = Float.valueOf(0);
                tongTienQuy1 += t;
            }
        }
        else {
            q.where(b.and(b.equal(b.function("YEAR", Integer.class, rHoaDon.get("createdDate")), Integer.parseInt(year)),
                    b.equal(b.function("QUARTER", Integer.class, rHoaDon.get("createdDate")), Integer.parseInt(quy))));
            q.multiselect(b.sum(rHoaDon.get("tongTien")));
            Query query1 = s.createQuery(q);
            List<Float> total = query1.getResultList();
            Float t = total.get(0);
            if(t == null)
                t = Float.valueOf(0);
            tongTienQuy1 += t;
        }
        Map<String,Float> result = new HashMap<>();
        result.put("quy", tongTienQuy1);
        return result;
    }

    @Override
    public Integer thongKeSoLuongTheoNam(String year) {
        Session s = factory.getObject().getCurrentSession();
        Query q = s.createQuery("select count(p) from PhieuKham p where YEAR(p.ngayKham) = :year");
        q.setParameter("year",Integer.parseInt(year));
        Object test = q.getResultList();
        return Integer.parseInt(q.getResultList().get(0).toString());
    }

    @Override
    public Map<String, Long> thongKeBenhNhanTheoQuy(String year, String quy) {
        Session s =factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object> q = b.createQuery(Object.class);
        Long soBenhNhan = 0L;
        Root rPhieuKham = q.from(PhieuKham.class);
        if(year.equals("")) {
            Query query = s.createQuery("select year(p.ngayKham) from PhieuKham p");
            List<Object> allYear = query.getResultList();
            Set<Object> set = new HashSet<>(allYear);
            for(Object o : set) {
                q.where(b.and(b.equal(b.function("YEAR", Integer.class, rPhieuKham.get("ngayKham")), Integer.parseInt(o.toString())),
                        b.equal(b.function("QUARTER", Integer.class, rPhieuKham.get("ngayKham")), Integer.parseInt(quy))));
                q.multiselect(b.count(rPhieuKham.get("maPK")));
                Query query1 = s.createQuery(q);
                List<Long> total = query1.getResultList();
                Long t = total.get(0);
                if(t == null)
                    t = 0L;
                soBenhNhan += t;
            }

        }
        else {
            q.where(b.and(b.equal(b.function("YEAR", Integer.class, rPhieuKham.get("ngayKham")), Integer.parseInt(year)),
                    b.equal(b.function("QUARTER", Integer.class, rPhieuKham.get("ngayKham")), Integer.parseInt(quy))));
            q.multiselect(b.count(rPhieuKham.get("maPK")));
            Query query1 = s.createQuery(q);
            List<Long> total = query1.getResultList();
            Long t = total.get(0);
            if(t == null)
                t = 0L;
            soBenhNhan += t;
        }
        Map<String,Long> result = new HashMap<>();
        result.put("quy", soBenhNhan);
        return result;
    }

    @Override
    public Float thongKeDoanhThuTheoThang(String year, String thang) {
        Session s =factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object> q = b.createQuery(Object.class);
        Float tongTienQuy1 = Float.valueOf(0);
        Root rHoaDon = q.from(HoaDon.class);
        if(year.equals("")){
            Query query = s.createQuery("select year(h.createdDate) from HoaDon h");
            List<Object> allYear =  query.getResultList();
            Set<Object> set = new HashSet<>(allYear);
            for(Object o : set){
                q.where(b.and(b.equal(b.function("YEAR", Integer.class, rHoaDon.get("createdDate")), Integer.parseInt(o.toString())),
                        b.equal(b.function("MONTH", Integer.class, rHoaDon.get("createdDate")), Integer.parseInt(thang))));
                q.multiselect(b.sum(rHoaDon.get("tongTien")));
                Query query1 = s.createQuery(q);
                List<Float> total = query1.getResultList();
                Float t = total.get(0);
                if(t == null)
                    t = Float.valueOf(0);
                tongTienQuy1 += t;
            }
        }
        else {
            q.where(b.and(b.equal(b.function("YEAR", Integer.class, rHoaDon.get("createdDate")), Integer.parseInt(year)),
                    b.equal(b.function("MONTH", Integer.class, rHoaDon.get("createdDate")), Integer.parseInt(thang))));
            q.multiselect(b.sum(rHoaDon.get("tongTien")));
            Query query1 = s.createQuery(q);
            List<Float> total = query1.getResultList();
            Float t = total.get(0);
            if(t == null)
                t = Float.valueOf(0);
            tongTienQuy1 += t;
        }
        return tongTienQuy1;
    }

    @Override
    public Long thongKeSoLuongTheoThang(String year, String thang) {
        Session s =factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object> q = b.createQuery(Object.class);
        Long soBenhNhan = 0L;
        Root rPhieuKham = q.from(PhieuKham.class);
        if(year.equals("")) {
            Query query = s.createQuery("select year(p.ngayKham) from PhieuKham p");
            List<Object> allYear = query.getResultList();
            Set<Object> set = new HashSet<>(allYear);
            for(Object o : set) {
                q.where(b.and(b.equal(b.function("YEAR", Integer.class, rPhieuKham.get("ngayKham")), Integer.parseInt(o.toString())),
                        b.equal(b.function("MONTH", Integer.class, rPhieuKham.get("ngayKham")), Integer.parseInt(thang))));
                q.multiselect(b.count(rPhieuKham.get("maPK")));
                Query query1 = s.createQuery(q);
                List<Long> total = query1.getResultList();
                Long t = total.get(0);
                if(t == null)
                    t = 0L;
                soBenhNhan += t;
            }

        }
        else {
            q.where(b.and(b.equal(b.function("YEAR", Integer.class, rPhieuKham.get("ngayKham")), Integer.parseInt(year)),
                    b.equal(b.function("MONTH", Integer.class, rPhieuKham.get("ngayKham")), Integer.parseInt(thang))));
            q.multiselect(b.count(rPhieuKham.get("maPK")));
            Query query1 = s.createQuery(q);
            List<Long> total = query1.getResultList();
            Long t = total.get(0);
            if(t == null)
                t = 0L;
            soBenhNhan += t;
        }
        return soBenhNhan;
    }

    @Override
    public Float thongKeDoanhThuTheoNam(String year) {
        Session s = factory.getObject().getCurrentSession();
        Query q = s.createQuery("select sum(p.tongTien) from HoaDon p where YEAR(p.createdDate) = :year");
        q.setParameter("year",Integer.parseInt(year));
        Object test = q.getResultList();
        return Float.parseFloat(q.getResultList().get(0).toString());
    }
}
