package com.springmvc.controller;

import com.springmvc.dto.ThuocDTO;
import com.springmvc.service.ThuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiThuocController {
    @Autowired
    private ThuocService thuocService;

    @GetMapping("/api/thuoc")
    public ResponseEntity<List<ThuocDTO>> getListThuoc(){
        return new ResponseEntity<>(
                this.thuocService.getListThuoc(),
                HttpStatus.OK);

    }
}
