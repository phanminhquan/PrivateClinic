package com.springmvc.controller;

import com.springmvc.dto.*;
import com.springmvc.dto.momoclasses.Environment;
import com.springmvc.dto.momoclasses.PaymentResponse;
import com.springmvc.enums.RequestType;
import com.springmvc.momoprocessor.CreateOrderMoMo;
import com.springmvc.service.BenhNhanService;
import com.springmvc.service.HoaDonService;
import com.springmvc.service.PhieuKhamService;
import com.springmvc.service.ThuocService;
import com.springmvc.share.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ApiPayController {
    @Autowired
    PhieuKhamService phieuKhamService;
    @Autowired
    BenhNhanService benhNhanService;
    @Autowired
    ThuocService thuocService;
    @Autowired
    HoaDonService hoaDonService;
    @PostMapping("/pay")
    public ResponseEntity<Map<String,String>> momoPay(@RequestBody Map<String,String> map) throws Exception {
        long idpk = Long.parseLong(map.get("idPK"));
        LogUtils.init();
        PhieuKhamDTO pk =  phieuKhamService.getPhieuKhamByID(idpk);
        BenhNhanDTO bn = benhNhanService.getBNById(pk.getMaBn());
        String requestId = String.valueOf(System.currentTimeMillis());
        String orderId = String.valueOf(System.currentTimeMillis());
        List<ThuocDTO> listThuoc = thuocService.getListThuocByPhieuKham(pk.getMaPk());
        Double tienThuoc = 0.0;
        for (ThuocDTO t : listThuoc){
            tienThuoc += t.getGiaBan();
        }
        Double amount = Util.tienKhamBacSi + tienThuoc;
        Date today= new Date();
        hoaDonService.saveHoaDon(new HoaDonDTO(null,Float.parseFloat(tienThuoc.toString()),Float.parseFloat( Util.tienKhamBacSi.toString()),Float.parseFloat(amount.toString()),today,pk.getMaPk()));
        String orderInfo = bn.getHoTen()+ " thanh toán hóa đơn khám " + pk.getMaPk();
        String returnURL = "https://google.com.vn";
        String notifyURL = "https://google.com.vn";
        Environment environment = Environment.selectEnv("dev");
        PaymentResponse captureWalletMoMoResponse = CreateOrderMoMo.process(environment, orderId, requestId, Integer.toString(amount.intValue()), orderInfo, returnURL, notifyURL, "", RequestType.CAPTURE_WALLET, Boolean.TRUE);
        String url = captureWalletMoMoResponse.getPayUrl();
        Map<String ,String> res = new HashMap<>();
        res.put("payUrl",url);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
