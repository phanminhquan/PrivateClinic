package com.springmvc.service;


import com.springmvc.dto.NhanVienDTO;
import com.springmvc.pojo.NhanVien;

import java.text.ParseException;
import java.util.List;

public interface NhanVienService {
    NhanVienDTO getNhanVienById(long id);
    List<NhanVienDTO> getListNV();
    List<NhanVienDTO> getListBS();

    List<NhanVienDTO> getListYT();

    NhanVienDTO addOrUpdateYta (NhanVienDTO nhanVienDTO) throws ParseException;
    NhanVienDTO addOrUpdateBacSi (NhanVienDTO nhanVienDTO) throws ParseException;

    void deleteNhanVien (Long id);
}
