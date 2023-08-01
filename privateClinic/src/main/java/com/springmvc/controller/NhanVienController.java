package com.springmvc.controller;

import com.springmvc.dto.NhanVienDTO;
import com.springmvc.pojo.NhanVien;
import com.springmvc.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@Controller
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping("/admin/bacsi")
    public String listBS (Model model)
    {
        model.addAttribute("doctor",nhanVienService.getListBS());
        return "doctor";
    }

    @GetMapping("/admin/yta")
    public String listYT (Model model)
    {
        model.addAttribute("yta",nhanVienService.getListYT());
        return "yta";
    }
    @GetMapping("/admin/add_yta")
    public String createYT (Model model)
    {
        model.addAttribute("yta", new NhanVienDTO());
        return "addyta";
    }
    @PostMapping ("/admin/yta")
    public String add (@ModelAttribute (value = "yta") @Valid NhanVienDTO nv, BindingResult rs) throws ParseException {

        if (!rs.hasErrors()) {
            nhanVienService.addOrUpdateYta(nv);
            return "redirect:/admin/yta";
        }
        return "addyta";
    }
    @DeleteMapping("/admin/yta/{id}")
    public String delete (@PathVariable("id") long id)
    {
        nhanVienService.deleteNhanVien(id);
        return "yta";
    }

    @GetMapping("/admin/yta/{id}")
    public String update(@PathVariable("id") long id,Model model){
        NhanVienDTO nv = this.nhanVienService.getNhanVienById(id);

        String year = nv.getNgaySinh().substring(0,4);
        String month = nv.getNgaySinh().substring(5,7);
        String date = nv.getNgaySinh().substring(8,10);
        String createDate = year.concat("-").concat(month).concat("-").concat(date);

        nv.setNgaySinh(createDate);
        model.addAttribute("yta",nv);
        return "addyta";
    }

}
