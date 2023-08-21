package com.springmvc.controller;

import com.springmvc.components.JwtService;
import com.springmvc.pojo.TaiKhoan;
import com.springmvc.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
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
}
