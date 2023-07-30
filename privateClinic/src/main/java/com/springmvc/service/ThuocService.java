package com.springmvc.service;

import com.springmvc.dto.ThuocDTO;

import java.util.List;

public interface ThuocService {
    List<ThuocDTO> getListThuoc();

    ThuocDTO createThuoc(ThuocDTO thuocDTO);


    ThuocDTO updateThuoc(ThuocDTO thuoc);

    ThuocDTO getThuocById(long id);
    void deleteThuoc(long id);
}
