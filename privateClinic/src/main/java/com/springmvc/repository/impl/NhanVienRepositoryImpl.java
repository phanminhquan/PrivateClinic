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
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;


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


    @Override
    public List<Object[]> getListNhanVienByIdCaTruc(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Query query = s.createQuery("select n.id,n.hoTen,n.dienThoai,n.email,role.ten,nvct.id " +
                "from NhanVien n " +
                " join  NhanvienCatruc nvct on n.id = nvct.idNV.id" +
                " join CaTrucTrongTuan cttt on cttt.id = nvct.idCT.id" +
                " join CaTruc ct on ct.id = cttt.idCaTruc.id " +
                " join UserRole role on role.id = n.idUser.id" +
                " where cttt.id =:id");
        query.setParameter("id" ,id);
        return query.getResultList();
    }
    @Override
    public List<Long> getAllMaNv() {
        Session s = this.factory.getObject().getCurrentSession();
        return  s.createQuery("select n.id from NhanVien n").getResultList();
    }
    @Override
    public List<String> getAllName() {
        Session s = this.factory.getObject().getCurrentSession();
        List<String> list = s.createQuery("select n.hoTen from NhanVien n").getResultList();
        Set<String> set =  new LinkedHashSet<>(list);
        return new ArrayList<>(set);
    }

    @Override
    public List<Object[]> GetAllListNhanVien(Map<String, String> map) {
        Session s = factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root rootNhanVien = q.from(NhanVien.class);
        Root rootUserRole = q.from(UserRole.class);
        List<Predicate> predicates = new ArrayList<>();
        q.multiselect(rootNhanVien.get("maNV"),rootNhanVien.get("hoTen"),rootNhanVien.get("ngaySinh"),
                rootNhanVien.get("email"),rootNhanVien.get("dienThoai"),rootNhanVien.get("diaChi"),rootUserRole.get("ten"));
        predicates.add(b.equal(rootNhanVien.get("idUser"), rootUserRole.get("id")));
        String name = map.get("tenNv");
        String maNv = map.get("maNv");
        if(map != null){
            if(name != null && !name.isEmpty()){
                predicates.add(b.like(rootNhanVien.get("hoTen"),String.format("%%%s%%", name)));
            }
            if(maNv != null && !maNv.isEmpty()){
                predicates.add(b.equal(rootNhanVien.get("maNV"),maNv));
            }
            q.where(predicates.toArray(Predicate[]::new));
        }
        Query query = s.createQuery(q);
        return query.getResultList();
    }

    @Override
    public List<NhanVien> getListNhanVienByCaTrucTrongTuan(int id) {
        Session s = factory.getObject().getCurrentSession();
        Query q = s.createQuery("select n from NhanVien n join NhanvienCatruc nct on n.id = nct.idNV.id" +
                " join CaTrucTrongTuan cttt on cttt.id = nct.idCT.id where cttt.id = :id");
        q.setParameter("id",id);

        return q.getResultList();
    }
}
