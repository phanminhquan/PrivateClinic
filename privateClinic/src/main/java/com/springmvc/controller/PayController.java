package com.springmvc.controller;

import com.springmvc.dto.*;
import com.springmvc.dto.momoclasses.Environment;
import com.springmvc.dto.momoclasses.PaymentResponse;
import com.springmvc.enums.RequestType;
import com.springmvc.momoprocessor.CreateOrderMoMo;
import com.springmvc.pojo.BenhNhan;
import com.springmvc.pojo.PhieuKham;
import com.springmvc.service.BenhNhanService;
import com.springmvc.service.HoaDonService;
import com.springmvc.service.PhieuKhamService;
import com.springmvc.service.ThuocService;
import com.springmvc.share.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.crypto.CipherInputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class PayController {
    @Autowired
    PhieuKhamService phieuKhamService;
    @Autowired
    BenhNhanService benhNhanService;
    @Autowired
    ThuocService thuocService;
    @Autowired
    HoaDonService hoaDonService;
    @GetMapping("/admin/pay")
    public String pay(Model model, @RequestParam Map<String, String> map){
        model.addAttribute("listPK" , phieuKhamService.getListObjUI(map));
        return "pay";
    }

}
