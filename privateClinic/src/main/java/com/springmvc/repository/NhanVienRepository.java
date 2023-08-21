package com.springmvc.repository;

import com.springmvc.pojo.NhanVien;
import com.springmvc.pojo.UserRole;

import java.util.List;
import java.util.Map;

public interface NhanVienRepository {
    NhanVien getNhanVienById(long id);
    List<NhanVien> getListNV();

    List<NhanVien> getListBS(Map<String , String> params);
    List<NhanVien> getListYT(Map<String, String> params);

    NhanVien addOrUpdateNhanVien (NhanVien nv);

    UserRole findUserRoleById (long id);

    void deleteNhanVien (long id);

    List<NhanVien> searchBS (String kw);
    List<NhanVien> searchYT (String kw);

    public Long countPromotion(long in);

    List<Object[]> getListNhanVienByIdCaTruc(int id);
    List<Long> getAllMaNv();
    List<String> getAllName();
    List<Object[]> GetAllListNhanVien(Map<String, String> map);
    List<NhanVien> getListNhanVienByCaTrucTrongTuan(int id);


}
