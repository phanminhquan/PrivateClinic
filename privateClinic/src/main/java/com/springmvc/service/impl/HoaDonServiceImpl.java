package com.springmvc.service.impl;

import com.springmvc.dto.HoaDonDTO;
import com.springmvc.pojo.HoaDon;
import com.springmvc.pojo.PhieuKham;
import com.springmvc.repository.HoaDonRepository;
import com.springmvc.repository.PhieuKhamRepository;
import com.springmvc.service.HoaDonService;
import com.springmvc.service.PhieuKhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HoaDonServiceImpl implements HoaDonService {
    @Autowired
    HoaDonRepository hoaDonRepository;
    @Autowired
    PhieuKhamRepository phieuKhamRepository;
    private HoaDon toEntity(HoaDonDTO hoaDonDTO){
        HoaDon hd = new HoaDon();
        if(hoaDonDTO.getMaHd() != null) {
            hd.setMaHD(hoaDonDTO.getMaHd());
        }
        hd.setCreatedDate(hoaDonDTO.getCreatedDate());
        PhieuKham pk = phieuKhamRepository.getPhieuKhamByID(hoaDonDTO.getMaPk());
        hd.setMaPK(pk);
        hd.setTienKham(hoaDonDTO.getTienKham());
        hd.setTienThuoc(hoaDonDTO.getTienThuoc());
        hd.setTongTien(hoaDonDTO.getTongTien());
        return hd;
    }
    @Override
    public void saveHoaDon(HoaDonDTO hoaDonDTO) {
        hoaDonRepository.savaHoaDon(toEntity(hoaDonDTO));
    }
}
