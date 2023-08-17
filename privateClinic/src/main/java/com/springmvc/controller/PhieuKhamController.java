package com.springmvc.controller;

import com.springmvc.dto.BenhNhanDTO;
import com.springmvc.dto.PhieuKhamDTO;
import com.springmvc.dto.ThuocDTO;
import com.springmvc.pojo.PhieuKham;
import com.springmvc.pojo.Thuoc;
import com.springmvc.service.BenhNhanService;
import com.springmvc.service.PhieuKhamService;
import com.springmvc.service.ThuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class PhieuKhamController {
    @Autowired
    PhieuKhamService phieuKhamService;
    @Autowired
    BenhNhanService benhNhanService;
    @Autowired
    ThuocService thuocService;
    @GetMapping("/admin/pheiukham/{id}")
    public String detail(@PathVariable("id") long id, Model model){
        PhieuKhamDTO phieuKhamDTO = phieuKhamService.getPhieuKhamByID(id);
        BenhNhanDTO benhNhanDTO = benhNhanService.getBNById(phieuKhamDTO.getMaBn());
        List<Object[]> thuocDTO = thuocService.listCustomUIByPhieuKham(phieuKhamDTO.getMaPk());
        model.addAttribute("phieuKham", phieuKhamDTO);
        model.addAttribute("thuoc", thuocDTO);
        model.addAttribute("benhNhan", benhNhanDTO);
        return "phieukhamdetail";
    }
}
