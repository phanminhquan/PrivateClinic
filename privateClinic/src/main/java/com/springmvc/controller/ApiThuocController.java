package com.springmvc.controller;

import com.springmvc.dto.PhieuThuocDTO;
import com.springmvc.dto.TaiKhoanDTO;
import com.springmvc.dto.ThuocDTO;
import com.springmvc.dto.Util;
import com.springmvc.service.PhieuThuocService;
import com.springmvc.service.TaiKhoanService;
import com.springmvc.service.ThuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ApiThuocController {
    @Autowired
    private ThuocService thuocService;
    @Autowired
    private TaiKhoanService taiKhoanService;
    @Autowired
    private PhieuThuocService phieuThuocService;

    @GetMapping("/api/thuoc")
    public ResponseEntity<List<ThuocDTO>> getListThuoc(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(
                this.thuocService.getListThuoc(params),
                HttpStatus.OK);
    }


    @DeleteMapping("api/thuoc/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteThuoc(@PathVariable("id") long id) {
        thuocService.deleteThuoc(id);
    }

    @PostMapping("api/admin/register")
    public ResponseEntity<TaiKhoanDTO> regist(@RequestBody TaiKhoanDTO taiKhoanDTO) {
        return new ResponseEntity<>(this.taiKhoanService.addTaiKhoan(taiKhoanDTO), HttpStatus.OK);
    }

    @PostMapping("/api/phieuthuoc")
    public ResponseEntity<PhieuThuocDTO> addPhieu(@RequestBody PhieuThuocDTO p) {
        Util.maPk = p.getMaPk();
        return new ResponseEntity<>(this.phieuThuocService.addPhieuThuoc(p), HttpStatus.OK);
    }
}
