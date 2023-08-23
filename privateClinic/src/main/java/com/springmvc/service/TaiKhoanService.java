package com.springmvc.service;

import com.springmvc.dto.TaiKhoanDTO;
import com.springmvc.pojo.TaiKhoan;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface TaiKhoanService extends UserDetailsService {
    TaiKhoanDTO addTaiKhoan(TaiKhoanDTO taiKhoanDTO);

    List<TaiKhoan> getListTaiKhoan(String name);

    TaiKhoanDTO getTaiKhoanById(Long id);

    List<TaiKhoanDTO> getAllTk();

    void deleteTaiKhoan(Long id);

    List<TaiKhoanDTO> searchTaiKhoan(String kw);

    TaiKhoan getTaiKhoanByUsername(String user);

    boolean authUser(String username, String password);
    TaiKhoanDTO register(Map<String,String> params, MultipartFile file);
    Boolean checkUserName(String username);

    TaiKhoanDTO addUser(TaiKhoanDTO taiKhoan);
}
