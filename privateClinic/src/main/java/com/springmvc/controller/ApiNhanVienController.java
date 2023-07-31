package com.springmvc.controller;

import com.springmvc.dto.NhanVienDTO;
import com.springmvc.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiNhanVienController {

    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping("api/admin/nhanvien")
    public ResponseEntity<List<NhanVienDTO>> getListNV ()
    {
        return new ResponseEntity<>(this.nhanVienService.getListNV(), HttpStatus.OK);
    }
    @GetMapping("api/admin/bacsi")
    public ResponseEntity<List<NhanVienDTO>> getListBS ()
    {
        return new ResponseEntity<>(this.nhanVienService.getListBS(), HttpStatus.OK);
    }
//    @PostMapping("api/admin/nhanvien")
//    public ResponseEntity<NhanVienDTO> addOrUpdateNV (@RequestBody NhanVienDTO nhanVienDTO)
//    {
//        return new ResponseEntity<>(this.nhanVienService.addOrUpdateNhanVien(nhanVienDTO),HttpStatus.NO_CONTENT);
//    }

    @DeleteMapping("api/admin/nhanvien/{id}")
    public void deleteNhanVien (@PathVariable("id") long id)
    {
         nhanVienService.deleteNhanVien(id);
    }
}
