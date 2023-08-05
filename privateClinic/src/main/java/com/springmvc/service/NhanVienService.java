package com.springmvc.service;


import com.springmvc.dto.NhanVienDTO;
import com.springmvc.pojo.NhanVien;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface NhanVienService {
    NhanVienDTO getNhanVienById(long id);
    public List<NhanVienDTO> getListNV();
    List<NhanVienDTO> getListBS(Map<String,String> params);

    List<NhanVienDTO> getListYT(Map<String , String> params);

    NhanVienDTO addOrUpdateYta (NhanVienDTO nhanVienDTO) throws ParseException;
    NhanVienDTO addOrUpdateBacSi (NhanVienDTO nhanVienDTO) throws ParseException;

    void deleteNhanVien (Long id);

    List<NhanVienDTO> searchBS(String kw);
    List<NhanVienDTO> searchYT(String kw);

    public Long countPromotion(long in);
}
