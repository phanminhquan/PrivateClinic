/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springmvc.controller;

import com.itextpdf.layout.property.ListSymbolAlignment;
import com.springmvc.dto.DateOfWeekDTO;
import com.springmvc.dto.Util;
import com.springmvc.pojo.DateOfWeek;
import com.springmvc.pojo.HoaDon;
import com.springmvc.pojo.PhieuKham;
import com.springmvc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private PhieuKhamService phieuKhamService;
    @Autowired
    private StatService statService;
    @Autowired
    private HoaDonService hoaDonService;

    @RequestMapping("/")
    public String index(Model model)
    {

        List<Integer> l = new ArrayList<>();
        for(Object o : phieuKhamService.getAllyear())
        {
            l.add(statService.thongKeSoluongTheoNam(o.toString()));
        }
        model.addAttribute("keys",phieuKhamService.getAllyear());
        model.addAttribute("thongkenam",l);
        for(DateOfWeekDTO d: dateOfWeekService.getListDateOfWeek()){
            model.addAttribute("date" + d.getId(),caTrucService.getListCaTrucByDayAnhNhanVien(d.getId(), Util.maNV));
        }
        model.addAttribute("nam",hoaDonService.getAllYear());
        List<Float> list = new ArrayList<>();
        for(Object o : hoaDonService.getAllYear())
        {
            list.add(statService.thongKeDoanhThuTheoNam(o.toString()));
        }
        model.addAttribute("thongkedoanhthunam",list);
        return "index";

    }


}
