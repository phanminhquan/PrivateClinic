package com.springmvc.repository;

import com.springmvc.pojo.NhanVien;
import com.springmvc.pojo.TaiKhoan;

import java.util.List;


public interface TaiKhoanRepository {
    TaiKhoan addTaiKhoan(TaiKhoan taiKhoan);

    List<TaiKhoan> getListTaiKhoan(String name);

    List<TaiKhoan> getAllTK();

    TaiKhoan getTKById(Long id);

    NhanVien findNVByID(Long id);

    //    TaiKhoanRole findtkByID ( Long id);
    void deleteTaiKhoan(long id);

    List<TaiKhoan> searchTaiKhoan(String kw);

    TaiKhoan getTkByUsername(String u);

    boolean authUser(String username, String password);

    TaiKhoan addUser(TaiKhoan taiKhoan);

}
