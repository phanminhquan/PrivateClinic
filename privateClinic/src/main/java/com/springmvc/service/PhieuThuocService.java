package com.springmvc.service;

import com.springmvc.dto.PhieuThuocDTO;
import com.springmvc.pojo.PhieuThuoc;

import java.util.List;

public interface PhieuThuocService {
    List<PhieuThuocDTO> getListPT ();

    PhieuThuocDTO addPhieuThuoc(PhieuThuocDTO phieuThuocDTO);
}
