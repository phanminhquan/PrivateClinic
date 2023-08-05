package com.springmvc.controller;

import com.springmvc.dto.NhanVienDTO;
import com.springmvc.dto.ThuocDTO;
import com.springmvc.service.ThuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.Map;

@Controller
public class ThuocController {
    @Autowired
    private ThuocService thuocService;

    @Autowired
    private Environment env;

    @GetMapping("/admin/thuoc")
    public String listBS (Model model,@RequestParam(value = "kw",required = false) String kw, @RequestParam Map<String,String> params)
    {
        if (kw != null)
        {
            model.addAttribute("thuoc",thuocService.searchThuoc(kw));
        }
        else {
            int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
            long count = this.thuocService.countPromotion(2);
            model.addAttribute("counter", Math.ceil(count * 1.0 / pageSize));
            model.addAttribute("thuoc", thuocService.getListThuoc(params));
        }
        return "thuoc";
    }

    @GetMapping("/admin/add_thuoc")
    public String createThuoc (Model model)
    {
        model.addAttribute("thuoc", new ThuocDTO());
        return "addThuoc";
    }

    @PostMapping("/admin/thuoc")
    public String add (@ModelAttribute(value = "thuoc") @Valid ThuocDTO t, BindingResult rs) throws ParseException {

        if (!rs.hasErrors()) {
            thuocService.addOrUpdateThuoc(t);
            return "redirect:/admin/thuoc";
        }
        return "addThuoc";
    }
    @GetMapping("/admin/thuoc/{id}")
    public String update(@PathVariable("id") long id, Model model){
        ThuocDTO t = this.thuocService.getThuocById(id);

        model.addAttribute("thuoc",t);
        return "addThuoc";
    }

}
