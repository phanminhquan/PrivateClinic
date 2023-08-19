package com.springmvc.repository;

import java.util.List;
import java.util.Map;

public interface StatRepository {
    Map<String,Float> thongKeDoanhThuTheoQuy(String year,String quy);

    Integer thongKeSoLuongTheoNam(String year);
    Map<String,Long> thongKeBenhNhanTheoQuy(String year,String quy);
    Float thongKeDoanhThuTheoThang(String year,String thang);

    Long thongKeSoLuongTheoThang (String year, String thang);

    Float thongKeDoanhThuTheoNam(String year);
}
