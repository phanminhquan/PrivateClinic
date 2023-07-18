/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springmvc.controller;

import com.springmvc.dto.ThuocDTO;
import com.springmvc.pojo.QuiDinh;
import com.springmvc.pojo.Thuoc;
import com.springmvc.service.QuiDinhService;
import com.springmvc.service.ThuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 *
 * @author user
 */
@Controller
public class HomeController {
    @Autowired
    private ThuocService thuocService;

    @RequestMapping("/")
    public String index(Model model)
    {
        List<ThuocDTO> q = thuocService.getListThuoc();
        model.addAttribute("thuoc", q);
        return "index";
    }
}
