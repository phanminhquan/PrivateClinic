/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springmvc.controller;

import com.springmvc.dto.DateOfWeekDTO;
import com.springmvc.dto.Util;
import com.springmvc.pojo.DateOfWeek;
import com.springmvc.service.CaTrucService;
import com.springmvc.service.DateOfWeekService;
import com.springmvc.service.ThuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author user
 */
@Controller
public class HomeController {
    @Autowired
    private ThuocService thuocService;
    @Autowired
    CaTrucService caTrucService;
    @Autowired
    DateOfWeekService dateOfWeekService;

    @RequestMapping("/")
    public String index(Model model)
    {

        for(DateOfWeekDTO d: dateOfWeekService.getListDateOfWeek()){
            model.addAttribute("date" + d.getId(),caTrucService.getListCaTrucByDayAnhNhanVien(d.getId(), Util.maNV));
        }
//        List<ThuocDTO> q = thuocService.getListThuoc();
//        model.addAttribute("thuoc", q);
        return "index";
    }
}
