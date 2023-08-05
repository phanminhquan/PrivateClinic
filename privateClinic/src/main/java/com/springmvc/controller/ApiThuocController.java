package com.springmvc.controller;

import com.springmvc.dto.ThuocDTO;
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

    @GetMapping("/api/thuoc")
    public ResponseEntity<List<ThuocDTO>> getListThuoc(@RequestParam Map<String,String> params){
        return new ResponseEntity<>(
                this.thuocService.getListThuoc(params),
                HttpStatus.OK);
    }



    @DeleteMapping("api/thuoc/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteThuoc(@PathVariable("id") long id){
        thuocService.deleteThuoc(id );
    }
}
