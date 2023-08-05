package com.springmvc.controller;

import com.springmvc.dto.NhanVienDTO;
import com.springmvc.pojo.NhanVien;
import com.springmvc.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@Controller
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private Environment env;

    @GetMapping("/admin/bacsi")
    public String listBS (Model model, @RequestParam(value = "kw", required = false) String kw,@RequestParam Map<String,String> params)
    {

        if ( kw != null)
            model.addAttribute("doctor", nhanVienService.searchBS(kw));
        else {
            int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
            long count = this.nhanVienService.countPromotion(1);
            model.addAttribute("doctor", nhanVienService.getListBS(params));
            model.addAttribute("counter", Math.ceil(count * 1.0 / pageSize));
        }
        return "doctor";
    }

    @GetMapping("/admin/yta")
    public String listYT (Model model, @RequestParam(value = "kw", required = false) String kw,@RequestParam Map<String,String> params)
    {
        if ( kw != null)
            model.addAttribute("yta", nhanVienService.searchYT(kw));
        else {
            int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
            long count = this.nhanVienService.countPromotion(2);
            model.addAttribute("yta", nhanVienService.getListYT(params));
            model.addAttribute("counter", Math.ceil(count * 1.0 / pageSize));
        }
        return "yta";
    }
    @GetMapping("/admin/add_yta")
    public String createYT (Model model)
    {
        model.addAttribute("yta", new NhanVienDTO());
        return "addyta";
    }

    @GetMapping("/admin/add_bacsi")
    public String createBS (Model model)
    {
        model.addAttribute("bacsi", new NhanVienDTO());
        return "addBacSi";
    }
    @PostMapping ("/admin/yta")
    public String add (@ModelAttribute (value = "yta") @Valid NhanVienDTO nv, BindingResult rs) throws ParseException {

        if (!rs.hasErrors()) {
            nhanVienService.addOrUpdateYta(nv);
            return "redirect:/admin/yta";
        }
        return "addyta";
    }

    @PostMapping ("/admin/bacsi")
    public String addbs (@ModelAttribute (value = "bacsi") @Valid NhanVienDTO nv, BindingResult rs) throws ParseException {

        if (!rs.hasErrors()) {
            nhanVienService.addOrUpdateBacSi(nv);
            return "redirect:/admin/bacsi";
        }
        return "addBacSi";
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

    @GetMapping("/admin/bacsi/{id}")
    public String updatebs(@PathVariable("id") long id,Model model){
        NhanVienDTO nv = this.nhanVienService.getNhanVienById(id);

        String year = nv.getNgaySinh().substring(0,4);
        String month = nv.getNgaySinh().substring(5,7);
        String date = nv.getNgaySinh().substring(8,10);
        String createDate = year.concat("-").concat(month).concat("-").concat(date);

        nv.setNgaySinh(createDate);
        model.addAttribute("bacsi",nv);
        return "addBacSi";
    }


}
