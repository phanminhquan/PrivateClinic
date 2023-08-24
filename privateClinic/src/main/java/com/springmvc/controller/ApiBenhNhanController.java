package com.springmvc.controller;

import com.springmvc.dto.BenhNhanDTO;
import com.springmvc.dto.CtDsKhamDTO;
import com.springmvc.service.BenhNhanService;
import com.springmvc.service.CtDsKhamService;
import com.springmvc.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ApiBenhNhanController {
    @Autowired
    private BenhNhanService benhNhanService;

    @Autowired
    private CtDsKhamService ctDsKhamService;

    @PostMapping(value = "/benhnhan/", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @CrossOrigin
    public ResponseEntity<BenhNhanDTO> addBenhNhan(@RequestParam("benhnhan") String params, @RequestPart("file") MultipartFile avatar) throws ParseException {
        BenhNhanDTO benhNhanDTO = new BenhNhanDTO();
        params = params.substring(1, params.length() - 1);
        String[] keyValuePairs = params.split(",");
        Map<String, String> map = new HashMap<>();

        for (String pair : keyValuePairs) {
            String[] entry = pair.split(":");
            map.put(entry[0].trim().substring(1, entry[0].length() - 1), entry[1].trim().substring(1, entry[1].length() - 1));
        }
        benhNhanDTO.setMaBn(null);
        benhNhanDTO.setHoTen(map.get("hoTen"));
        benhNhanDTO.setDienThoai(map.get("dienThoai"));
        benhNhanDTO.setEmail(map.get("email"));
        String year = map.get("ngaySinh").substring(0, 4);
        String month = map.get("ngaySinh").substring(5, 7);
        String date = map.get("ngaySinh").substring(8, 10);
        String createDate = date.concat("/").concat(month).concat("/").concat(year);
        Date d = Utils.dateParse(createDate);
        benhNhanDTO.setNgaySinh(d);
        benhNhanDTO.setGioiTinh(Integer.parseInt(map.get("gioiTinh")) == 1);
        benhNhanDTO.setDiaChi(map.get("diaChi"));
        benhNhanDTO.setFile(avatar);
        benhNhanDTO.setIdTk(Long.parseLong(map.get("idTk")));
        return new ResponseEntity<>(this.benhNhanService.addBenhNhan(benhNhanDTO), HttpStatus.CREATED);
    }

    @PostMapping("/api/lichkham")
    @CrossOrigin
    public ResponseEntity<CtDsKhamDTO> addLichKham(@RequestBody Map<String, String> req) throws ParseException {
        CtDsKhamDTO ctDsKhamDTO = new CtDsKhamDTO();
        ctDsKhamDTO.setMaBn(Long.parseLong(req.get("maBN")));
        ctDsKhamDTO.setTrangthai(Integer.parseInt(req.get("trangThai")));
        ctDsKhamDTO.setMaTg(Long.parseLong(req.get("maTG")));

        String year = req.get("ngayKham").substring(0, 4);
        String month = req.get("ngayKham").substring(5, 7);
        String date = req.get("ngayKham").substring(8, 10);
        String createDate = date.concat("/").concat(month).concat("/").concat(year);
        Date d = Utils.dateParse(createDate);

        ctDsKhamDTO.setNgayKham(d);
        return new ResponseEntity<>(this.ctDsKhamService.addLichKham(ctDsKhamDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/api/lichkham/{id}")
    @CrossOrigin
    public void DeleteLichKham(@PathVariable("id") Long id) {
        ctDsKhamService.DeleteLichKham(id);
    }
}
