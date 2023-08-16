package com.springmvc.controller;


import com.springmvc.service.CtDsKhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
public class CTDSKhamController {

    @Autowired
    CtDsKhamService ctDsKhamService;



    @GetMapping("/admin/dskham")
    public String dsKham(Model model, @RequestParam Map<String, String> map){
        map.put("status", "1");
        model.addAttribute("ds" , ctDsKhamService.getListCtDSKham(map));
        return "danhsachphieukham";
    }
    @GetMapping("/admin/dskhamhomnay")
    public String dsKhamToDay(Model model, @RequestParam Map<String, String> map){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String data = df.format(new Date());
        map.put("status", "2");
        map.put("date", data);
        model.addAttribute("dsToday" , ctDsKhamService.getListCtDSKham(map));
        return "dskhamhomnay";
    }
 }
