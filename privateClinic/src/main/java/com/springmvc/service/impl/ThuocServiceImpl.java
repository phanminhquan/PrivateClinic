package com.springmvc.service.impl;

import com.springmvc.dto.ThuocDTO;
import com.springmvc.pojo.Thuoc;
import com.springmvc.repository.Thuocrepository;
import com.springmvc.service.ThuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ThuocServiceImpl implements ThuocService {
    @Autowired
    private Thuocrepository thuocrepository;
    public ThuocDTO toDto(Thuoc thuoc){
        ThuocDTO t = new ThuocDTO();
        t.setDonVi(thuoc.getDonVi());
        t.setMaThuoc(thuoc.getMaThuoc());
        t.setHinhAnh(thuoc.getHinhAnh());
        t.setMoTa(thuoc.getMoTa());
        t.setIsActive(thuoc.getIsActive());
        t.setGiaBan(thuoc.getGiaBan());
        t.setTenThuoc(thuoc.getTenThuoc());
        t.setSoLuong(thuoc.getSoLuong());
        return t;
    }
    public List<ThuocDTO> toThuocDTOList(List<Thuoc> t){
        List<ThuocDTO> thuocDTOS = new ArrayList<>();
        for (Thuoc thuoc: t)
        {
            ThuocDTO dto = toDto(thuoc);
            thuocDTOS.add(dto);
        }
        return  thuocDTOS;
    }
    @Override
    public List<ThuocDTO> getListThuoc() {
        List<Thuoc> thuoc = thuocrepository.getListThuoc();
        return toThuocDTOList(thuoc);
    }
}
