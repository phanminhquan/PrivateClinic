package com.springmvc.controller;

import com.springmvc.dto.BacSiDTO;
import com.springmvc.dto.ThuocDTO;
import com.springmvc.service.BacSiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiBacSiController {
    @Autowired
    private BacSiService bacSiService;
    @GetMapping("/api/bacsi/")
    public ResponseEntity<List<BacSiDTO>> getListBS()
    {
        return new ResponseEntity<>(this.bacSiService.getListBS(),HttpStatus.OK);
    }

    @PostMapping("/api/bacsi/")
    public ResponseEntity<BacSiDTO> createBacSi(@RequestBody BacSiDTO bacSiDTO)
    {
        return null;
    }

}
