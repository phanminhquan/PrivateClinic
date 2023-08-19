package com.springmvc.service;

import com.springmvc.dto.HoaDonDTO;

import java.util.Set;

public interface HoaDonService {
    void saveHoaDon(HoaDonDTO hoaDonDTO);
    Set<Object> getAllYear();
}
