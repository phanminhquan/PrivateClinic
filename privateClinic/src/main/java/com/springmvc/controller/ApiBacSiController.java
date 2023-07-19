package com.springmvc.controller;

import com.springmvc.dto.BacSiDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiBacSiController {

    @GetMapping("/api/bacsi/")
    public ResponseEntity<List<BacSiDTO>> getListBS()
    {
        return null;
    }
}
