package com.springmvc.controller;

import com.springmvc.components.JwtService;
import com.springmvc.dto.TaiKhoanDTO;
import com.springmvc.pojo.TaiKhoan;
import com.springmvc.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jmx.export.metadata.ManagedOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class ApiTaiKhoanController {
    @Autowired
    private TaiKhoanService taiKhoanService;
    @Autowired
    private JwtService jwtService;

    @DeleteMapping("api/taikhoan/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTaiKhoan(@PathVariable("id") long id) {
        taiKhoanService.deleteTaiKhoan(id);
    }

    @PostMapping("/api/login/")
    @CrossOrigin
    public ResponseEntity<String> login(@RequestBody TaiKhoan user) {
        if (this.taiKhoanService.authUser(user.getUsername(), user.getPassword()) == true) {
            String token = this.jwtService.generateTokenLogin(user.getUsername());

            return new ResponseEntity<>(token, HttpStatus.OK);
        }

        return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/api/test/")
    @CrossOrigin(origins = {"127.0.0.1:5500"})
    public ResponseEntity<String> test(Principal pricipal) {
        return new ResponseEntity<>("SUCCESSFUL", HttpStatus.OK);
    }

//    @PostMapping(path = "/api/users/",
//            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
//            produces = {MediaType.APPLICATION_JSON_VALUE})
//    @CrossOrigin
//    public ResponseEntity<TaiKhoanDTO> addUser(@RequestParam Map<String, String> params, @RequestPart MultipartFile avatar) {
//        TaiKhoanDTO user = this.userService.addUser(params, avatar);
//        return new ResponseEntity<>(user, HttpStatus.CREATED);
//    }

    @GetMapping(path = "/api/current-user/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<TaiKhoan> details(Principal user) {
        TaiKhoan u = this.taiKhoanService.getTaiKhoanByUsername(user.getName());
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    @PostMapping(value = "/register/",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @CrossOrigin
    public ResponseEntity<Map<String,String>> register(@RequestParam("taikhoan") String params,@RequestPart("file") MultipartFile avatar){
        Map<String,String> res = new HashMap<>();
        params= params.substring(1, params.length()-1);
        String[] keyValuePairs = params.split(",");
        Map<String,String> map = new HashMap<>();

        for(String pair : keyValuePairs)
        {
            String[] entry = pair.split(":");
            map.put(entry[0].trim().substring(1,entry[0].length()-1), entry[1].trim().substring(1,entry[1].length()-1));
        }
        if(map.get("confirmPassword").equals(map.get("password"))){
            TaiKhoanDTO t = taiKhoanService.register(map,avatar);
            res.put("username", t.getUsername());
            res.put("password",t.getPassword());
            res.put("result","Ok");
            return new ResponseEntity<>(res,HttpStatus.OK);
        }
        else {
            res.put("result","Mật khẩu không trùng");
            return new ResponseEntity<>(res,HttpStatus.OK);
        }

    }
    @PostMapping("/checkusername/")
    public ResponseEntity<Boolean> checkusername(@RequestBody Map<String, String> req){
        return new ResponseEntity<>(taiKhoanService.checkUserName(req.get("username")),HttpStatus.OK);
    }

}
