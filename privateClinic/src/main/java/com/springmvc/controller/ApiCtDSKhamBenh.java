package com.springmvc.controller;


import com.springmvc.dto.CtDsKhamDTO;
import com.springmvc.service.CtDsKhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiCtDSKhamBenh {
    @Autowired
    private CtDsKhamService ctDsKhamService;

    @GetMapping("/api/ctdskham/")
    ResponseEntity<List<CtDsKhamDTO>> getCtDsKham(){
        return new ResponseEntity<>(ctDsKhamService.getListCtDSKham(), HttpStatus.OK);
    }

}
