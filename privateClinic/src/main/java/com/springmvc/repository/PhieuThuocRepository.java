package com.springmvc.repository;

import com.springmvc.pojo.PhieuThuoc;

import java.util.List;

public interface PhieuThuocRepository {
    List<PhieuThuoc> getListPT ();

    PhieuThuoc addPhieuThuoc (PhieuThuoc phieuThuoc);
}
