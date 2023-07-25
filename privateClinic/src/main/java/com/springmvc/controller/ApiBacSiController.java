package com.springmvc.controller;

import com.springmvc.customresponse.BacSiResponse;
import com.springmvc.dto.BacSiDTO;
import com.springmvc.dto.ThuocDTO;
import com.springmvc.service.BacSiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ApiBacSiController {
    @Autowired
    private BacSiService bacSiService;
    @GetMapping("/api/bacsi/")
    public ResponseEntity<List<BacSiDTO>> getListBS()
    {
        return new ResponseEntity<>(this.bacSiService.getListBS(),HttpStatus.OK);
    }
    @GetMapping("/api/bacsicus/")
    public ResponseEntity<List<Object[]>> getListBSCus(@RequestParam Map<String, String> params)
    {
        return new ResponseEntity<>(this.bacSiService.getList(params),HttpStatus.OK);
    }


    @PostMapping("/api/bacsi/")
    public ResponseEntity<BacSiDTO> createBacSi(@RequestBody BacSiDTO bacSiDTO)
    {
        return new ResponseEntity<>(this.bacSiService.createBS(bacSiDTO),HttpStatus.CREATED);
    }

    @PutMapping("/api/bacsi/{id}")
    public ResponseEntity<BacSiDTO> updateBacSi(@RequestBody BacSiDTO bacSiDTO, @PathVariable("id") long id)
    {
        bacSiDTO.setMaBs(id);
        return  new ResponseEntity<>(this.bacSiService.updateBS(bacSiDTO),HttpStatus.OK);
    }
    @DeleteMapping("/api/bacsi/{id}")
    public void deleteBaSi(@PathVariable("id") long id)
    {
        bacSiService.deleteBS(id);
    }

    @GetMapping("/api/bacsi/{id}")
    public ResponseEntity<BacSiDTO> GetBacSi(@PathVariable("id") long id)
    {
        return  new ResponseEntity<>(this.bacSiService.findBSByID(id),HttpStatus.OK);
    }

}
