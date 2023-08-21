package com.springmvc.service;

import com.springmvc.dto.TaiKhoanDTO;
import com.springmvc.pojo.TaiKhoan;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface TaiKhoanService extends UserDetailsService {
    TaiKhoanDTO addTaiKhoan(TaiKhoanDTO taiKhoanDTO);

    List<TaiKhoan> getListTaiKhoan(String name);

    TaiKhoanDTO getTaiKhoanById(Long id);

    List<TaiKhoanDTO> getAllTk();

    void deleteTaiKhoan(Long id);

    List<TaiKhoanDTO> searchTaiKhoan(String kw);

    TaiKhoan getTaiKhoanByUsername(String user);

    boolean authUser(String username, String password);

//    TaiKhoan addUser(Map<String, String> params, MultipartFile avatar);
}
