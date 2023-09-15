package com.springmvc.repository.impl;

import com.springmvc.pojo.BenhNhan;
import com.springmvc.pojo.CtDsKham;
import com.springmvc.pojo.TaiKhoan;
import com.springmvc.pojo.ThoiGian;
import com.springmvc.repository.CtDsKhamRepository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


@Repository
@Transactional
public class CtDsKhamRepositoryImpl implements CtDsKhamRepository {
    @Autowired
    LocalSessionFactoryBean factory;
    @Autowired
    private SimpleDateFormat f;

    public void sendMail(String username, String email, String result) {
        SimpleMailMessage newEmail = new SimpleMailMessage();
        newEmail.setTo(email);
        newEmail.setSubject("Xác nhận lịch khám");
        newEmail.setText("Xin chào " + username);
    }


    @Override
    public Map<String, String> AcceptOrdennyDanhSachKham(long id, Integer status) {
        Session s = factory.getObject().getCurrentSession();
        CtDsKham ct = s.get(CtDsKham.class, id);
        Map<String, String> m = new HashMap<>();
        if (status == 2) {
            Query q = s.createQuery("from CtDsKham c where c.ngaykham = :date");
            q.setParameter("date", ct.getNgaykham());
            int soLichHen = q.getResultList().size();
            if (soLichHen == 100) {
                m.put("status", "0");
            } else {
                ct.setTrangthai(status);
                s.update(ct);
                String email = ct.getMaBN().getEmail();
                m.put("status", "1");
                m.put("name", ct.getMaBN().getHoTen());
                m.put("email", ct.getMaBN().getEmail());

                return m;
            }
        } else if (status == 3) {
            ct.setTrangthai(status);
            s.update(ct);
            m.put("status", "2");
            return m;
        }
        m.put("msg", "lỗi");
        return m;
    }

    @Override
    public List<Object[]> getListCtDSKham(Map<String, String> params) {
        Session s = factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root rdsKham = q.from(CtDsKham.class);
        Root rBenhNhan = q.from(BenhNhan.class);
        Root rThoiGian = q.from(ThoiGian.class);
        q.multiselect(rdsKham.get("maCTDS"), rBenhNhan.get("hoTen"), rThoiGian.get("maTG"), rdsKham.get("ngaykham"));
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rdsKham.get("maBN"), rBenhNhan.get("maBN")));
        predicates.add(b.equal(rdsKham.get("maTG"), rThoiGian.get("maTG")));
        String status = params.get("status");
        if (status != null && !status.isEmpty()) {
            predicates.add(b.equal(rdsKham.get("trangthai"), Integer.parseInt(status)));
        }
        String name = params.get("hoTen");
        if (name != null && !name.isEmpty()) {
            predicates.add(b.like(rBenhNhan.get("hoTen"), String.format("%%%s%%", name)));
        }
        String date = params.get("date");
        if (date != null && !date.isEmpty()) {
            try {
                predicates.add(b.equal(rdsKham.get("ngaykham"), f.parse(date)));
            } catch (ParseException ex) {
                Logger.getLogger(CtDsKhamRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        q.where(predicates.toArray(Predicate[]::new));


        Query query = s.createQuery(q);
        return query.getResultList();
    }

    @Override
    public CtDsKham addLichKham(CtDsKham ctDsKham) {
        Session s = factory.getObject().getCurrentSession();
        s.save(ctDsKham);
        return ctDsKham;
    }

    @Override
    public void DeleteLichKham(Long id) {
        Session s = factory.getObject().getCurrentSession();
        s.delete(s.get(CtDsKham.class, id));
    }

    @Override
    public List<Object[]> getListHistoryByUser(Long idtk, Map<String, String> params) {
        Session s = factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root lichHen = q.from(CtDsKham.class);
        Root taiKhoan = q.from(TaiKhoan.class);
        Root benhNhan = q.from(BenhNhan.class);
        Root thoiGian = q.from(ThoiGian.class);
        String now = params.get("now");
        q.multiselect(lichHen.get("maCTDS"), lichHen.get("trangthai"), lichHen.get("ngaykham"), thoiGian.get("gio"));
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(lichHen.get("maBN"), benhNhan.get("maBN")));
        predicates.add(b.equal(taiKhoan.get("id"), benhNhan.get("idTk")));
        predicates.add(b.equal(lichHen.get("maTG"), thoiGian.get("maTG")));
        
        if (now.equals("true"))
            predicates.add(b.greaterThanOrEqualTo(lichHen.get("ngaykham"), new Date()));
        else
            predicates.add(b.lessThan(lichHen.get("ngaykham"), new Date()));
        predicates.add(b.equal(taiKhoan.get("id"), idtk));
        String maLichHen = params.get("malichhen");
        if (maLichHen != null && !maLichHen.isEmpty()) {
            Long id = Long.parseLong(maLichHen);
            predicates.add(b.equal(lichHen.get("maCTDS"), id));
        }
        String fd = params.get("fromDate");
        if (fd != null && !fd.isEmpty()) {
            try {
                predicates.add(b.greaterThanOrEqualTo(lichHen.get("ngaykham"), f.parse(fd)));
            } catch (ParseException ex) {
                Logger.getLogger(CtDsKhamRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        String td = params.get("toDate");
        if (td != null && !td.isEmpty()) {
            try {
                predicates.add(b.lessThanOrEqualTo(lichHen.get("ngaykham"), f.parse(td)));
            } catch (ParseException ex) {
                Logger.getLogger(CtDsKhamRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        q.where(predicates.toArray(Predicate[]::new));

        Query query = s.createQuery(q);
        return query.getResultList();
    }

    @Override
    public void huyLichHen(Long id) {
        Session s = factory.getObject().getCurrentSession();
        CtDsKham c = s.get(CtDsKham.class, id);
        c.setTrangthai(3);
        s.update(c);
    }
}
