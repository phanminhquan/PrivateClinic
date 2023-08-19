package com.springmvc.repository;

import com.springmvc.pojo.HoaDon;

import java.util.List;
import java.util.Set;

public interface HoaDonRepository {
    void savaHoaDon(HoaDon hoaDon);
    Set<Object> getAllYear();
}
