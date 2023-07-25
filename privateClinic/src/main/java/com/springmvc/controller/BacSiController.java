package com.springmvc.controller;


import com.springmvc.customresponse.BacSiResponse;
import com.springmvc.dto.BacSiDTO;
import com.springmvc.service.BacSiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class BacSiController {
    @Autowired
    BacSiService bacSiService;

    @GetMapping("/admin/bacsi")
    public String quanLyBacSi(Model model, @RequestParam Map<String, String> params){
        List<String> chuyenMon = bacSiService.getAllChuyenMon();
        List<Object[]> bacSiList = bacSiService.getList(params);
        model.addAttribute("chuyenmon", chuyenMon);
        model.addAttribute("bacsi", bacSiList);
        return "doctor";
    }
}
