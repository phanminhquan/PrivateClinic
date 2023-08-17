package com.springmvc.controller;

import com.springmvc.dto.CaTrucDTO;
import com.springmvc.dto.DateOfWeekDTO;

import com.springmvc.service.CaTrucService;
import com.springmvc.service.DateOfWeekService;
import com.springmvc.service.NhanVienService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class CaTrucController {
    @Autowired
    DateOfWeekService dateOfWeekService;
    @Autowired
    CaTrucService caTrucService;

    @Autowired
    NhanVienService nhanVienService;
    @GetMapping("/catruc")
    public String index(Model model){
        model.addAttribute("date" ,dateOfWeekService.getListDateOfWeek());
        List<List<CaTrucDTO>> list = new ArrayList<>();
        for (DateOfWeekDTO d : dateOfWeekService.getListDateOfWeek()){
            list.add(caTrucService.getListCaTrucByDate(d.getId()));
        }
        model.addAttribute("list" ,list);
        model.addAttribute("listCaTruc",caTrucService.getListCaTruc());
        return "catruc";
    }

    @GetMapping("/catruc/{id}")
    public String detail(@PathVariable("id") int id, Model model, @RequestParam Map<String, String> map){
        model.addAttribute("idCaTruc", id);
        model.addAttribute("listNhanVien", nhanVienService.getListNhanvVienByCaTruc(id));
        model.addAttribute("allMaNv", nhanVienService.getAllMaNv());
        model.addAttribute("allName", nhanVienService.getAllName());
        model.addAttribute("allSearchlistNV", nhanVienService.getAllListNhanVien(map));
        return "catrucdetail";
    }

    @GetMapping("/catruc/edit/{id}")
    public String editShiftInDay(@PathVariable("id") int id, Model model){
        model.addAttribute("dateOfWeek", dateOfWeekService.getDateOfWeekById(id));
        model.addAttribute("allCaTruc", caTrucService.getListCaTrucByDate(id));
        model.addAttribute("list", caTrucService.getListCaTruc());
        return "catruc_edit";
    }

    @GetMapping("/admin/addcatruc/{id}")
    public String updateCatru(@PathVariable("id") int id, Model model){
        CaTrucDTO ct = caTrucService.getCaTrucById(id);
        model.addAttribute("catruc", ct);
        return "addcatruc";

    }

    @PostMapping("/admin/catruc/addct")
    public String addCaTruc(@ModelAttribute(value = "catruc") @Valid CaTrucDTO caTrucDTO, BindingResult rs, RedirectAttributes redirectAttributes) throws ParseException {

        if (!rs.hasErrors()) {
            CaTrucDTO test = caTrucService.addOrUpdateCaTruc(caTrucDTO);
            if (test == null){
                redirectAttributes.addFlashAttribute("erroWhileAdding","Thêm ca trực với giờ trùng với ca khác");
                redirectAttributes.addFlashAttribute("catruc",new CaTrucDTO());
                return "redirect:/admin/addcatruc";
            }
            return "redirect:/catruc";
        }
        return "addcatruc";
    }
    @GetMapping("/admin/addcatruc")
    public String catruc(Model model){
        model.addAttribute("catruc", new CaTrucDTO());
        return "addcatruc";
    }

    @GetMapping("/catruc/nhanvien")
    public String caTrucOfNhanVien()
    {
        return "catruc_nhanvien";
    }


}
