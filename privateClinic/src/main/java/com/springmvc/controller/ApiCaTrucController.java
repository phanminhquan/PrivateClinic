package com.springmvc.controller;

import com.springmvc.pojo.CaTruc;
import com.springmvc.service.CaTrucService;
import com.springmvc.service.NhanVienCaTrucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

@RestController
public class ApiCaTrucController {
    @Autowired
    private CaTrucService caTrucService;
    @PostMapping(value = "/catruc/add",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Map<String,String>> addNhanVien(@RequestBody Map<String ,String> map)
    {
        Map<String,String> res = new HashMap<>();
        long idNhanVien = Long.parseLong(map.get("idNhanVien"));
        int idCT = Integer.parseInt(map.get("idCaTruc"));
        res.put("message",caTrucService.addNhanVienToCaTruc(idNhanVien,idCT));
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @DeleteMapping("/api/catruc/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteNhanVienCaTruc(@PathVariable("id") int id){
        caTrucService.delNhanVienCaTruc(id);
    }

    @DeleteMapping("/api/catructrongtuan")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delCatrucTrongTuan(@RequestBody Map<String,String> map ){
        int idCaTruc = Integer.parseInt(map.get("idCaTruc"));
        int idNgay = Integer.parseInt(map.get("idNgay"));
        caTrucService.delCaTrucTrongTuan(idCaTruc,idNgay);
    }

    @DeleteMapping("api/delcatruc/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void delCaTruc(@PathVariable("id") int id){
        caTrucService.delCaTruc(id);
    }
    @PostMapping("/admin/addCaTrucVaoNgay")
    public ResponseEntity<List<Integer>> addCaTrucVaoNgay(@RequestBody Map<String, String> map, RedirectAttributes redirectAttributes ) throws IOException {
        List<Integer> key = new ArrayList<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals("true")) {
                key.add(Integer.parseInt(entry.getKey()));
            }
        }
        int idNgay = Integer.parseInt(map.get("id").toString());
        List<Integer> list = this.caTrucService.addCaTrucVaoNgay(key,idNgay);
        if(list != null)
            return new ResponseEntity<>(list,HttpStatus.OK);
        else
            return  new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    }

}
