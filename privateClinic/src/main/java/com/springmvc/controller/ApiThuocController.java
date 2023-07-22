package com.springmvc.controller;

import com.springmvc.dto.ThuocDTO;
import com.springmvc.service.ThuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/api/thuoc")
    public ResponseEntity<ThuocDTO> createThuoc(@RequestBody ThuocDTO thuocDTO)
    {
        return new ResponseEntity<>(this.thuocService.createThuoc(thuocDTO),HttpStatus.CREATED);
    }

    @GetMapping("/api/thuoc/{id}")
    public  ResponseEntity<ThuocDTO> getThuocById(@PathVariable("id") long id){
        return  new ResponseEntity<>(this.thuocService.getThuocById(id), HttpStatus.OK);
    }

    @PutMapping("/api/thuoc/{id}")
    public ResponseEntity<ThuocDTO> updateThuoc(@PathVariable("id") long id, @RequestBody ThuocDTO t){
        t.setMaThuoc(id);
        return new ResponseEntity<>(this.thuocService.updateThuoc(t) ,HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/api/thuoc/{id}")
    public void deleteThuoc(@PathVariable("id") long id){
        thuocService.deleteThuoc(id );
    }
}
