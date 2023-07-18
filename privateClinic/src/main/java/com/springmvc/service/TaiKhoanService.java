package com.springmvc.service;

import com.springmvc.pojo.TaiKhoan;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface TaiKhoanService extends UserDetailsService {
    boolean addTaiKhoan(TaiKhoan taiKhoan);
    List<TaiKhoan> getListTaiKhoan(String name);
}
