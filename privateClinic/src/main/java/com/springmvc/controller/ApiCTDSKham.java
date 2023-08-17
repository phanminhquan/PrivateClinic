package com.springmvc.controller;


import com.springmvc.service.CtDsKhamService;
import com.springmvc.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ApiCTDSKham {
    @Autowired
    CtDsKhamService ctDsKhamService;
    @Autowired
    EmailService emailService;
    @GetMapping("/api/ctdskham/havenotaccepted")
    ResponseEntity<Map<String ,Integer>> getlistHaveNotAccepted(){
        Map<String,Integer> res = new HashMap<>();
        Map<String,String> map = new HashMap<>();
        map.put("status","1");
        int count = ctDsKhamService.getListCtDSKham(map).size();
        res.put("count",count);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/mail")
    void sendMail(@RequestBody Map<String,String> req){
        String username = req.get("username");
        String email = req.get("email");
        String id = req.get("id");
        emailService.sendMail(username,email,id,"test");
    }
    @PostMapping("/api/lichkham/acceptOrDenny")
    ResponseEntity<Map<String,String>> acceptOrDennyLichKham(@RequestBody Map<String,String> req){
        Map<String,String> res = new HashMap<>();
        int id = Integer.parseInt(req.get("id").toString());
        int status = Integer.parseInt(req.get("status").toString());

        String result ="";
        Map<String,String> map = ctDsKhamService.AcceptOrdennyDanhSachKham(id,status);
        switch ( Integer.parseInt(map.get("status"))){
            case 0:
                result = "Trong ngày đã đủ 100 lịch khám";
                break;
            case 1:
                result = "Xác nhận lịch khám thành công";
                String username = map.get("name");
                res.put("username" , username);
                res.put("email",map.get("email").toString());
                res.put("id",Integer.toString(id));

                break;
            case 2:
                result = "Hủy lịch khám thành công";
            case 3:
                result= "Lỗi";
        }
        res.put("res",result);
        return new ResponseEntity<>(res,HttpStatus.OK);
    }
}
