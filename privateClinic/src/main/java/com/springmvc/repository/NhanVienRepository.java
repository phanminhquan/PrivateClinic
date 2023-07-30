package com.springmvc.repository;

import com.springmvc.pojo.NhanVien;
import com.springmvc.pojo.UserRole;

import java.util.List;

public interface NhanVienRepository {
    NhanVien getNhanVienById(long id);
    List<NhanVien> getListNV();

    List<NhanVien> getListBS();
    List<NhanVien> getListYT();

    NhanVien addOrUpdateNhanVien (NhanVien nv);

    UserRole findUserRoleById (long id);

    void deleteNhanVien (long id);
}
