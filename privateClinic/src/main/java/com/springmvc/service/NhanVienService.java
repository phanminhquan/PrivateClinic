package com.springmvc.service;


import com.springmvc.dto.NhanVienDTO;
import com.springmvc.pojo.NhanVien;

import java.util.List;

public interface NhanVienService {
    NhanVienDTO getNhanVienById(long id);
    List<NhanVienDTO> getListNV();
    List<NhanVienDTO> getListBS();

    List<NhanVienDTO> getListYT();

    NhanVienDTO addOrUpdateNhanVien (NhanVienDTO nhanVienDTO);

    void deleteNhanVien (Long id);
}
