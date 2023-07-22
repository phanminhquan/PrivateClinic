package com.springmvc.controller;

import com.springmvc.dto.BacSiDTO;
import com.springmvc.dto.YtaDTO;
import com.springmvc.service.YTaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiYtaController {
    @Autowired
    YTaService yTaService;

    @GetMapping("api/yta/")
    public ResponseEntity<List<YtaDTO>> getListYTa(){
        return new ResponseEntity<>(yTaService.listYta(), HttpStatus.OK);
    }

    @GetMapping("api/yta/{id}/")
    public  ResponseEntity<YtaDTO> getYTaByID(@PathVariable("id") long id){
        return new ResponseEntity<>(yTaService.getYTaByID(id),HttpStatus.OK);
    }
    @PostMapping("api/yta/")
    public  ResponseEntity<YtaDTO> createYTa(@RequestBody YtaDTO ytaDTO){
        return new ResponseEntity<>(yTaService.createYta(ytaDTO),HttpStatus.CREATED);
    }
    @DeleteMapping("/api/yta/{id}")
    public void deleteBaSi(@PathVariable("id") long id)
    {
        yTaService.deleteYTa(id);
    }

    @PutMapping("/api/yta/{id}")
    public ResponseEntity<YtaDTO> updateBacSi(@RequestBody YtaDTO ytaDTO, @PathVariable("id") long id)
    {
        ytaDTO.setMaYt(id);
        return  new ResponseEntity<>(this.yTaService.updateYTa(ytaDTO),HttpStatus.OK);
    }
}
