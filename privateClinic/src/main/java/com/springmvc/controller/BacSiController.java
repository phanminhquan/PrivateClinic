package com.springmvc.controller;

import com.springmvc.dto.BenhNhanDTO;
import com.springmvc.dto.PhieuKhamDTO;
import com.springmvc.dto.PhieuThuocDTO;
import com.springmvc.dto.Util;
import com.springmvc.service.*;
import com.springmvc.service.impl.PDFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class BacSiController {
    @Autowired
    private BenhNhanService benhNhanService;

    @Autowired
    private PhieuKhamService phieuKhamService;

    @Autowired
    private PhieuThuocService phieuThuocService;

    @Autowired
    private ThuocService thuocService;
    @Autowired
    private PDFService pdfService;
    @Autowired
    private NhanVienService nhanVienService;


    @GetMapping("/admin/phieukham")
    public String getBenhNhan(Model model, @RequestParam(value = "kw", required = false) String kw, @RequestParam Map<String, String> params) {
        PhieuKhamDTO pk = new PhieuKhamDTO();
        pk.setMaBS(Util.maNV);
        model.addAttribute("phieukham", pk);
        model.addAttribute("phieuthuoc", new PhieuThuocDTO());
        model.addAttribute("listphieuthuoc", phieuThuocService.getListPT());
        model.addAttribute("phieukhambenh", phieuKhamService.getlistPK());

        List<String> listBN = new ArrayList<>();
        for (PhieuKhamDTO p : phieuKhamService.getlistPK()) {
            listBN.add(benhNhanService.getBNById(p.getMaBn()).getHoTen());
        }
        model.addAttribute("listTen", listBN);

        List<String> listThuoc = new ArrayList<>();
        for (PhieuThuocDTO t : phieuThuocService.getListPT()) {
            listThuoc.add(thuocService.getThuocById(t.getMaThuoc()).getTenThuoc());
        }
        model.addAttribute("listTenThuoc", listThuoc);

        if (kw != null) {
            model.addAttribute("benhnhan", benhNhanService.SearchBN(kw));
            model.addAttribute("thuoc", thuocService.searchThuoc(kw));
        } else {
            model.addAttribute("thuoc", thuocService.getListThuoc(params));
            model.addAttribute("benhnhan", benhNhanService.getALL(params));
        }
        return "phieukham";
    }

    @GetMapping("/admin/benhnhan/{id}")
    public String getIdBenhNhan(@PathVariable("id") long id, Model model) {
        model.addAttribute("benhnhan", phieuKhamService.getBenhNhanByID(id));
        return "phieukham";
    }


    @PostMapping("/admin/phieukham")
    public String add(@ModelAttribute(value = "phieukham") @Valid PhieuKhamDTO t,
                      @ModelAttribute(value = "phieuthuoc") @Valid PhieuThuocDTO p,
                      BindingResult rs) throws ParseException {

        if (!rs.hasErrors()) {
            if (t.getNgayKham() != null) {
                phieuKhamService.addOrUpdatePhieu(t);
                return "redirect:/admin/phieukham";
            } else {
                phieuThuocService.addPhieuThuoc(p);
                return "redirect:/admin/phieukham";
            }
        }
        return "phieukham";
    }

    @GetMapping("/admin/pdf")
    public void generatePDF(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename*=UTF-8''" + currentDateTime +".pdf";
        response.setHeader(headerKey, headerValue);
        response.addHeader("Content-Type", "application/pdf; charset=UTF-8");
        BenhNhanDTO bn = benhNhanService.getBNById(phieuKhamService.getPhieuKhamByID(Util.maPk).getMaBn());
        PhieuKhamDTO pk = phieuKhamService.getPhieuKhamByID(Util.maPk);
        List<Object[]> listThuoc = thuocService.getListByIDPK(pk.getMaPk());
        pdfService.export(response, bn, pk, listThuoc);
    }

    @GetMapping("/lichsukham")
    public String getListPK(Model model, @RequestParam(value = "kw", required = false) String kw) {

        if (kw != null) {
            model.addAttribute("pk", phieuKhamService.findPkByName(kw));
            List<String> listBN = new ArrayList<>();
            for (PhieuKhamDTO p : phieuKhamService.findPkByName(kw)) {
                listBN.add(benhNhanService.getBNById(p.getMaBn()).getHoTen());
            }
            model.addAttribute("listTenbn", listBN);
            List<String> listBS = new ArrayList<>();
            for (PhieuKhamDTO p : phieuKhamService.findPkByName(kw)) {
                listBS.add(nhanVienService.getNhanVienById(p.getMaBS()).getHoTen());
            }
            model.addAttribute("listTenbs", listBS);
        } else {

            model.addAttribute("pk", phieuKhamService.getAllPhieuKham());
            List<String> listBN = new ArrayList<>();
            for (PhieuKhamDTO p : phieuKhamService.getAllPhieuKham()) {
                listBN.add(benhNhanService.getBNById(p.getMaBn()).getHoTen());
            }
            model.addAttribute("listTenbn", listBN);
            List<String> listBS = new ArrayList<>();
            for (PhieuKhamDTO p : phieuKhamService.getAllPhieuKham()) {
                listBS.add(nhanVienService.getNhanVienById(p.getMaBS()).getHoTen());
            }
            model.addAttribute("listTenbs", listBS);
        }

        return "lichsukham";
    }
}
