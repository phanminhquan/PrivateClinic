package com.springmvc.controller;

import com.springmvc.dto.TaiKhoanDTO;
import com.springmvc.dto.ThuocDTO;
import com.springmvc.pojo.TaiKhoan;
import com.springmvc.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;

@Controller
public class TaiKhoanController {

    @Autowired
    private TaiKhoanService taiKhoanService;
    @GetMapping("/admin/login")
    public String login(){
        return "login";
    }

    @GetMapping("/admin/register")
    public String register(Model model){
        model.addAttribute("dangki", new TaiKhoanDTO());
        return "dangKy";
    }
    @PostMapping("/admin/register")
    public String register (Model model, @ModelAttribute(value = "dangki") @Valid TaiKhoanDTO dangki, BindingResult rs) throws ParseException
    {
        String errMsg = "";
        if (!rs.hasErrors()) {
            if (dangki.getPassword().equals(dangki.getConfirmPassword()))
            {
                taiKhoanService.addTaiKhoan(dangki);
                return "redirect:/admin/taikhoan";
            }else {
                errMsg = "Mật khẩu không trùng khớp";
                model.addAttribute("error",errMsg);
            }


        }
        return "dangKy";
    }
    @PostMapping("/admin/upRegister")
    public String upregister (Model model, @ModelAttribute(value = "dangki") @Valid TaiKhoanDTO dangki, BindingResult rs) throws ParseException
    {
        String errMsg = "";
        if (!rs.hasErrors()) {
            taiKhoanService.addTaiKhoan(dangki);
            return "redirect:/admin/taikhoan";
        }
        return "upTaiKhoan";
    }
    @GetMapping("/admin/taikhoan")
    public String getTk (Model model, @RequestParam(value = "kw",required = false) String kw)
    {
        if (kw != null)
        {
            model.addAttribute("taikhoan",taiKhoanService.searchTaiKhoan(kw));
        }
        else
            model.addAttribute("taikhoan", taiKhoanService.getAllTk());
        return "taikhoan";
    }

    @GetMapping("/admin/taikhoan/{id}")
    public String update(@PathVariable("id") long id, Model model){
        TaiKhoanDTO t = this.taiKhoanService.getTaiKhoanById(id);
        model.addAttribute("dangki",t);
        return "upTaiKhoan";
    }
}
