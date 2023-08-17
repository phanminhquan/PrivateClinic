package com.springmvc.repository;

import com.springmvc.pojo.BenhNhan;
import com.springmvc.pojo.NhanVien;
import com.springmvc.pojo.PhieuKham;
import java.util.Map;
import java.util.List;

public interface PhieuKhamRepository {

    PhieuKham createPhieuKham(PhieuKham phieuKham);

    List<PhieuKham> getlistPK();

    BenhNhan getBenhNhanVById(Long id);

    PhieuKham getPKById(Long id);

    PhieuKham addOrUpdatePhieu(PhieuKham phieuKham);

    NhanVien getNhanVienById(Long id);

    PhieuKham getPhieuKhamByID(Long id);

    List<PhieuKham> getAllPhieuKham();

    List<PhieuKham> findPkByName(String kw);
    List<Object[]> listObjPayUI(Map<String,String> param);
}



