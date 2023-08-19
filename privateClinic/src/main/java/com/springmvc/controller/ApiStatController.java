package com.springmvc.controller;


import com.springmvc.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ApiStatController {
    @Autowired
    StatService statService;

    @PostMapping("/admin/chartdoanhthu/quy")
    ResponseEntity<Map<String,Float>> doanhThuTheoQuy(@RequestBody Map<String,String> map){
        String year = map.get("year");
        Map<String,Float> res = new HashMap<>();
        res.put("Quý 1", statService.thongKeDoanhThuTheoQuy(year,"1").get("quy"));
        res.put("Quý 2", statService.thongKeDoanhThuTheoQuy(year,"2").get("quy"));
        res.put("Quý 3", statService.thongKeDoanhThuTheoQuy(year,"3").get("quy"));
        res.put("Quý 4", statService.thongKeDoanhThuTheoQuy(year,"4").get("quy"));
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    @PostMapping("/admin/chartbenhnhan/quy")
    ResponseEntity<Map<String,Long>> benhNhanTheoQuy(@RequestBody Map<String,String> map){
        String year = map.get("year");
        Map<String,Long> res = new HashMap<>();
        res.put("Quý 1", statService.thongKeBenhNhanhTheoQuy(year,"1").get("quy"));
        res.put("Quý 2", statService.thongKeBenhNhanhTheoQuy(year,"2").get("quy"));
        res.put("Quý 3", statService.thongKeBenhNhanhTheoQuy(year,"3").get("quy"));
        res.put("Quý 4", statService.thongKeBenhNhanhTheoQuy(year,"4").get("quy"));
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    @PostMapping("/admin/chartdoanhthu/thang")
    ResponseEntity<Map<String,Float>> doanhThuTheoThang(@RequestBody Map<String,String> map){
        String year = map.get("year");
        Map<String,Float> res = new HashMap<>();
        for(int i=1; i <=12;i++){
            res.put("Tháng "+i,statService.thongKeDoanhThuTheoThang(year,Integer.toString(i)));
        }
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @PostMapping("/admin/chartsoluong/thang")
    ResponseEntity<Map<String,Long>> SoLuongTheoThang(@RequestBody Map<String,String> map){
        String year = map.get("year");
        Map<String,Long> res = new HashMap<>();
        for(int i=1; i <=12;i++){
            res.put("Tháng "+i,statService.thongKeBenhNhanTheoThang(year,Integer.toString(i)));
        }
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

}
