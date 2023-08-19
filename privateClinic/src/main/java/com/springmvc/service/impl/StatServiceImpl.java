package com.springmvc.service.impl;

import com.springmvc.repository.StatRepository;
import com.springmvc.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class StatServiceImpl implements StatService {
    @Autowired
    StatRepository statRepository;
    @Override
    public Map<String, Float> thongKeDoanhThuTheoQuy(String year, String quy) {
        return statRepository.thongKeDoanhThuTheoQuy(year,quy);
    }

    @Override
    public Map<String, Long> thongKeBenhNhanhTheoQuy(String year, String quy) {
        return statRepository.thongKeBenhNhanTheoQuy(year,quy);
    }

    @Override
    public Integer thongKeSoluongTheoNam(String year) {
        return statRepository.thongKeSoLuongTheoNam(year);
    }

    @Override
    public Float thongKeDoanhThuTheoThang(String year, String thang) {
        return statRepository.thongKeDoanhThuTheoThang(year,thang);
    }

    @Override
    public Long thongKeBenhNhanTheoThang(String year, String thang) {
        return statRepository.thongKeSoLuongTheoThang(year,thang);
    }

    @Override
    public Float thongKeDoanhThuTheoNam(String year) {
        return statRepository.thongKeDoanhThuTheoNam(year);
    }
}
