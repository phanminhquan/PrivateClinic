package com.springmvc.service;

import java.util.Map;

public interface StatService {
    Map<String,Float> thongKeDoanhThuTheoQuy(String year, String quy);
    Map<String,Long> thongKeBenhNhanhTheoQuy(String year, String quy);

    Integer thongKeSoluongTheoNam(String year);
    Float thongKeDoanhThuTheoThang(String year, String thang);

    Long thongKeBenhNhanTheoThang (String year, String thang);
    Float thongKeDoanhThuTheoNam(String year);
}
