package com.springmvc.controller;

import com.springmvc.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiTaiKhoanController {
    @Autowired
    private TaiKhoanService taiKhoanService;

    @DeleteMapping("api/taikhoan/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteThuoc(@PathVariable("id") long id){
        taiKhoanService.deleteTaiKhoan(id);
    }
}
