package com.springmvc.repository.impl;


import com.springmvc.pojo.NhanVien;
import com.springmvc.pojo.Yta;
import com.springmvc.repository.YTaRepository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Repository
@Transactional
public class YTaRepositoryImpl implements YTaRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Yta> listYta() {
        Session s = factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Yta ");
        return q.getResultList();
    }

    @Override
    public Yta getYTaByID(long id) {
        Session s = factory.getObject().getCurrentSession();
        return s.get(Yta.class,id);
    }

    @Override
    public void deleteYTa(long id) {
        Session s = factory.getObject().getCurrentSession();
        Yta y = s.get(Yta.class,id);
        s.delete(y);
    }

    @Override
    public Yta updateYTa(Yta yta) {
        Yta yt = new Yta();
        Session s = factory.getObject().getCurrentSession();
        yt = s.get(Yta.class, yta.getMaYT());
        yt.setBangCap(yta.getBangCap());
        yt.setMaNV(yta.getMaNV());
        s.update(yt);
        return  yt;
    }

    @Override
    public Yta createYta(Yta yta) {
        Session s = factory.getObject().getCurrentSession();
        s.save(yta);
        return yta;
    }

    @Override
    public NhanVien findUserById(Long id) {
        NhanVien nv = new NhanVien();
        Session s = factory.getObject().getCurrentSession();
        nv = s.get(NhanVien.class,id);
        return nv;
    }

}
