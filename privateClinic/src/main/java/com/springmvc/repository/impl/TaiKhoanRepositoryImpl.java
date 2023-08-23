package com.springmvc.repository.impl;

import com.springmvc.pojo.NhanVien;
import com.springmvc.pojo.TaiKhoan;
import com.springmvc.repository.TaiKhoanRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;


@Repository
@Transactional
public class TaiKhoanRepositoryImpl implements TaiKhoanRepository {
    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private BCryptPasswordEncoder passEncoder;


    @Override
    public TaiKhoan addTaiKhoan(TaiKhoan taiKhoan) {
        Session session = factory.getObject().getCurrentSession();

        if (taiKhoan.getId() == null)
            session.save(taiKhoan);
        else
            session.update(taiKhoan);

        return taiKhoan;
    }

    @Override
    public List<TaiKhoan> getListTaiKhoan(String name) {
        Session session = factory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TaiKhoan> query = builder.createQuery(TaiKhoan.class);
        Root root = query.from(TaiKhoan.class);
        query = query.select(root);

        if (!name.isEmpty()) {
            Predicate p = builder.equal(root.get("username").as(String.class), name.trim());
            query = query.where(p);
        }

        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public List<TaiKhoan> getAllTK() {
        Session session = factory.getObject().getCurrentSession();
        Query q = session.createQuery("from TaiKhoan ");
        return q.getResultList();
    }

    @Override
    public TaiKhoan getTKById(Long id) {
        Session session = factory.getObject().getCurrentSession();
        return session.get(TaiKhoan.class, id);
    }

    @Override
    public NhanVien findNVByID(Long id) {
        Session session = factory.getObject().getCurrentSession();
        return session.get(NhanVien.class, id);
    }

//    @Override
//    public TaiKhoanRole findtkByID(Long id) {
//        Session session = factory.getObject().getCurrentSession();
//        return session.get(TaiKhoanRole.class,id);
//    }

    @Override
    public void deleteTaiKhoan(long id) {
        Session session = factory.getObject().getCurrentSession();
        session.delete(session.get(TaiKhoan.class, id));
    }

    @Override
    public List<TaiKhoan> searchTaiKhoan(String kw) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("from TaiKhoan where name like :ten");
        q.setParameter("ten", "%" + kw.toUpperCase() + "%");
        return q.getResultList();
    }

    @Override
    public TaiKhoan getTkByUsername(String u) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("from TaiKhoan where username = :user");
        q.setParameter("user", u);
        return (TaiKhoan) q.getSingleResult();
    }

    @Override
    public boolean authUser(String username, String password) {
        TaiKhoan tk = this.getTkByUsername(username);
        return this.passEncoder.matches(password, tk.getPassword());
    }

    @Override
    public TaiKhoan addUser(TaiKhoan taiKhoan) {
        Session s = this.factory.getObject().getCurrentSession();
        s.save(taiKhoan);
        return taiKhoan;
    }

    @Override
    public Boolean checkUserName(String username) {
        Session s = factory.getObject().getCurrentSession();
        Query q = s.createQuery("from TaiKhoan ");
        List<TaiKhoan> tk= q.getResultList();
        for(TaiKhoan u : tk){
            if (u.getUsername().equals(username)){
                return false;
            }

        }
        return true;
    }

}
