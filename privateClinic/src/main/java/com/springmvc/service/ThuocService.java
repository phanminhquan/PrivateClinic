package com.springmvc.service;

import com.springmvc.dto.NhanVienDTO;
import com.springmvc.dto.ThuocDTO;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface ThuocService {
    List<ThuocDTO> getListThuoc(Map<String , String> params);

    ThuocDTO addOrUpdateThuoc (ThuocDTO thuocDTO) throws ParseException;

    ThuocDTO getThuocById(long id);
    void deleteThuoc(Long id);
    List<ThuocDTO> searchThuoc (String kw);

    public Long countPromotion(long in);
}
