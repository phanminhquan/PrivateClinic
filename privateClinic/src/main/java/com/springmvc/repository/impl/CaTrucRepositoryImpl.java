package com.springmvc.repository.impl;

import com.springmvc.pojo.*;
import com.springmvc.repository.CaTrucRepository;
import com.springmvc.repository.NhanVienRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;


@Repository
@Transactional
public class CaTrucRepositoryImpl implements CaTrucRepository {
    @Autowired
    private LocalSessionFactoryBean factory;

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Override
    public List<CaTruc> getListCaTrucByDate(int date) {
        Session session = this.factory.getObject().getCurrentSession();
        Query q = session.createQuery("select c from CaTruc c join CaTrucTrongTuan ct on c.id = ct.idCaTruc.id" +
                " join DateOfWeek d on d.id = ct.idNgay.id where d.id = :id");
        q.setParameter("id", date);
        return q.getResultList();
    }

    @Override
    public List<CaTruc> getListCaTruc() {
        return factory.getObject().getCurrentSession().createQuery("FROM CaTruc ").getResultList();
    }

    @Override
    public CaTrucTrongTuan getCaTrucTrongTuanByID(int id) {
        Session s = factory.getObject().getCurrentSession();
        return s.get(CaTrucTrongTuan.class, id);
    }

    @Override
    public NhanvienCatruc getNhanVienCaTrucById(int id) {
        Session s = factory.getObject().getCurrentSession();
        NhanvienCatruc n = s.get(NhanvienCatruc.class, id);
        return n;
    }

    @Override
    public void delNhanVienCaTruc(int id) {
        Session s = factory.getObject().getCurrentSession();
        s.delete(getNhanVienCaTrucById(id));
    }

    @Override
    public void delCaTrucTrongTuan(int idCaTruc, int dateOfWeek) {
        Session s = factory.getObject().getCurrentSession();
        CaTruc caTruc = s.get(CaTruc.class, idCaTruc);
        DateOfWeek date = s.get(DateOfWeek.class, dateOfWeek);
        Query q = s.createQuery("select d from CaTrucTrongTuan d where d.idNgay.id = :idNgay and d.idCaTruc.id = :idCaTruc");
        q.setParameter("idNgay", dateOfWeek);
        q.setParameter("idCaTruc", idCaTruc);
        CaTrucTrongTuan caTrucTrongTuan = (CaTrucTrongTuan) q.getResultList().get(0);

        List<NhanvienCatruc> list = new ArrayList<>();
        if (caTrucTrongTuan != null) {
            int idCTTT = caTrucTrongTuan.getId();
            Query q2 = s.createQuery("from NhanvienCatruc nvct where nvct.idCT.id = :id");
            q2.setParameter("id", idCTTT);
            list = q2.getResultList();
            for (NhanvienCatruc i : list) {
                s.delete(i);
            }

        }
        s.delete(caTrucTrongTuan);

    }


    @Override
    public CaTruc addOrUpDateCaTruc(CaTruc caTruc) {
        Session s = factory.getObject().getCurrentSession();
        List<CaTruc> list = this.getListCaTruc();
        if (caTruc.getMaCT() == null) {
            if (list.size() == 0)
                s.save(caTruc);
            else {
                for (CaTruc c : list) {
                    if (caTruc.getGioTruc().before(caTruc.getGioKetThuc())) {
                        if ((caTruc.getGioTruc().after(c.getGioTruc()) && caTruc.getGioTruc().before(c.getGioKetThuc()))
                                || (caTruc.getGioKetThuc().after(c.getGioTruc()) && caTruc.getGioKetThuc().before(c.getGioKetThuc()))
                                || (caTruc.getGioTruc().before(c.getGioTruc()) && caTruc.getGioKetThuc().after(c.getGioKetThuc()))
                                || (caTruc.getGioKetThuc().before(c.getGioKetThuc()) && caTruc.getGioTruc().after(c.getGioTruc()))
                                || (caTruc.getGioKetThuc().after(c.getGioTruc()) && caTruc.getGioKetThuc().after(c.getGioKetThuc()))
                                || (caTruc.getGioTruc().before(c.getGioKetThuc()) && caTruc.getGioKetThuc().before(c.getGioTruc()))
                                || (caTruc.getGioKetThuc().after(c.getGioTruc()) && caTruc.getGioTruc().before(c.getGioKetThuc())))
                            return null;
                        else
                            s.save(caTruc);
                    } else {
                        if ((caTruc.getGioTruc().before(c.getGioKetThuc()) && caTruc.getGioKetThuc().after(c.getGioTruc()))
                                || (caTruc.getGioKetThuc().after(c.getGioTruc()) && caTruc.getGioTruc().after(c.getGioKetThuc()))
                                || (caTruc.getGioKetThuc().before(c.getGioTruc()) && caTruc.getGioTruc().before(c.getGioKetThuc()))
                                || caTruc.getGioTruc().before(c.getGioTruc())) {
                            return null;
                        } else
                            s.save(caTruc);
                    }
                }
            }
        } else {
            CaTruc ct = s.get(CaTruc.class, caTruc.getMaCT());
            list.remove(ct);
            if(list.size() == 0)
                s.update(caTruc);
            else {
                for (CaTruc c : list) {
                    if (caTruc.getGioTruc().before(caTruc.getGioKetThuc())) {
                        if ((caTruc.getGioTruc().after(c.getGioTruc()) && caTruc.getGioTruc().before(c.getGioKetThuc()))
                                || (caTruc.getGioKetThuc().after(c.getGioTruc()) && caTruc.getGioKetThuc().before(c.getGioKetThuc()))
                                || (caTruc.getGioTruc().before(c.getGioTruc()) && caTruc.getGioKetThuc().after(c.getGioKetThuc()))
                                || (caTruc.getGioKetThuc().before(c.getGioKetThuc()) && caTruc.getGioTruc().after(c.getGioTruc()))
                                || (caTruc.getGioKetThuc().after(c.getGioTruc()) && caTruc.getGioKetThuc().after(c.getGioKetThuc()))
                                || (caTruc.getGioTruc().before(c.getGioKetThuc()) && caTruc.getGioKetThuc().before(c.getGioTruc()))
                                || (caTruc.getGioKetThuc().after(c.getGioTruc()) && caTruc.getGioTruc().before(c.getGioKetThuc())))
                            return null;
                        else
                            s.update(caTruc);
                    } else {
                        if ((caTruc.getGioTruc().before(c.getGioKetThuc()) && caTruc.getGioKetThuc().after(c.getGioTruc()))
                                || (caTruc.getGioKetThuc().after(c.getGioTruc()) && caTruc.getGioTruc().after(c.getGioKetThuc()))
                                || (caTruc.getGioKetThuc().before(c.getGioTruc()) && caTruc.getGioTruc().before(c.getGioKetThuc()))
                                || caTruc.getGioTruc().before(c.getGioTruc())) {
                            return null;
                        } else
                            s.update(caTruc);
                    }


                }
            }

        }
        return caTruc;
    }

    @Override
    public List<Integer> addCaTrucVaoNgay(List<Integer> listId, int idNgay) {
        Boolean isContain = false;
        Session s = factory.getObject().getCurrentSession();
        List<Integer> ls = new ArrayList<>();
        for (Integer i : listId) {
            Query q = s.createQuery("from CaTrucTrongTuan ct where ct.idCaTruc.id = :idct and ct.idNgay.id = :idNgay ");
            q.setParameter("idct", i);
            q.setParameter("idNgay", idNgay);
            if (q.getResultList().size() > 0) {
                CaTrucTrongTuan c = (CaTrucTrongTuan) q.getResultList().get(0);
                ls.add(c.getId());
            }
        }
        if (ls.size() == 0) {
            for (Integer i : listId) {
                CaTruc c = s.get(CaTruc.class, i);
                DateOfWeek d = s.get(DateOfWeek.class, idNgay);
                s.save(new CaTrucTrongTuan(null, c, d));
            }
            return ls;
        }
        return null;
    }

    @Override
    public void delCaTruc(int id) {
        Session s = factory.getObject().getCurrentSession();
        List<CaTrucTrongTuan> listcttt = new ArrayList<>();
        Query q = s.createQuery("from CaTrucTrongTuan ct where ct.idCaTruc.id = :id");
        q.setParameter("id", id);
        listcttt = q.getResultList();
        for (CaTrucTrongTuan c : listcttt) {
            int idctt = c.getId();
            Query q2 = s.createQuery("from NhanvienCatruc nvct where nvct.idCT.id = :id");
            q2.setParameter("id", idctt);
            List<NhanvienCatruc> list = q2.getResultList();
            for (NhanvienCatruc nv : list) {
                s.delete(nv);
            }
            s.delete(c);
        }
        CaTruc c = s.get(CaTruc.class, id);
        s.delete(c);
    }

    @Override
    public CaTruc getCaTrucById(int id) {
        Session s = factory.getObject().getCurrentSession();
        return s.get(CaTruc.class,id);
    }

    @Override
    public List<CaTruc> getListCaTrucByDateAndIdNV(int dateId, long idnv) {
        Session s = factory.getObject().getCurrentSession();
        Query q = s.createQuery("select c from CaTruc c join CaTrucTrongTuan ct on c.id = ct.idCaTruc.id " +
                "join DateOfWeek d on d.id = ct.idNgay.id " +
                "join NhanvienCatruc nvct on nvct.idCT.id = ct.id " +
                "where nvct.idNV.id = :idnv and d.id = :date");
        q.setParameter("date",dateId);
        q.setParameter("idnv",idnv);
        return q.getResultList();
    }

    @Override
    public String addStaffToShift(long idNhanVien, int idCT) {
        Session s = factory.getObject().getCurrentSession();
        Query q = s.createQuery("select n.id from NhanvienCatruc n where n.idCT.id = :idCT and n.idNV.id = :idNV");
        q.setParameter("idCT", idCT);
        q.setParameter("idNV", idNhanVien);
        int id = q.getResultList().size();
        if (id != 0) {
            return "Nhân viên có sẵn trong ca";
        } else {
            CaTrucTrongTuan ct = getCaTrucTrongTuanByID(idCT);
            NhanVien nv = nhanVienRepository.getNhanVienById(idNhanVien);
            NhanvienCatruc n = new NhanvienCatruc(null, ct, nv);
            s.save(n);
            return "Lưu thành công";
        }
    }
}
