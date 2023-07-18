package com.springmvc.repository;

import com.springmvc.pojo.TaiKhoan;

import java.util.List;


public interface TaiKhoanRepository {
    boolean addTaiKhoan(TaiKhoan taiKhoan);
    List<TaiKhoan> getListTaiKhoan(String name);
}
