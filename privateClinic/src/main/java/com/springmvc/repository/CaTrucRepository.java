package com.springmvc.repository;

import com.springmvc.pojo.CaTruc;
import com.springmvc.pojo.CaTrucTrongTuan;
import com.springmvc.pojo.NhanvienCatruc;

import java.util.List;

public interface CaTrucRepository {
    List<CaTruc> getListCaTrucByDate(int date);

    List<CaTruc> getListCaTruc();

    String addStaffToShift(long idNhanVien, int idCT);

    CaTrucTrongTuan getCaTrucTrongTuanByID(int id);

    NhanvienCatruc getNhanVienCaTrucById(int id);

    void delNhanVienCaTruc(int id);

    void delCaTrucTrongTuan(int idCaTruc, int dateOfWeek);

    CaTruc addOrUpDateCaTruc(CaTruc caTruc);

    List<Integer> addCaTrucVaoNgay(List<Integer> listId, int idNgay);
    void delCaTruc(int id);
    CaTruc getCaTrucById(int id);
}
