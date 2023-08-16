package com.springmvc.service.impl;

import com.springmvc.dto.PhieuThuocDTO;
import com.springmvc.pojo.PhieuKham;
import com.springmvc.pojo.PhieuThuoc;
import com.springmvc.pojo.Thuoc;
import com.springmvc.repository.PhieuKhamRepository;
import com.springmvc.repository.PhieuThuocRepository;
import com.springmvc.repository.Thuocrepository;
import com.springmvc.service.PhieuThuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhieuThuocServiceImpl implements PhieuThuocService {
    @Autowired
    private PhieuThuocRepository phieuThuocRepository;
    @Autowired
    private Thuocrepository thuocrepository;
    @Autowired
    private PhieuKhamRepository phieuKhamRepository;

    public PhieuThuocDTO toDTO (PhieuThuoc phieuThuoc)
    {
        PhieuThuocDTO p = new PhieuThuocDTO();
        p.setMaPkThuoc(phieuThuoc.getMaPKThuoc());
        p.setSoLuong(phieuThuoc.getSoLuong());
        p.setCachDung(phieuThuoc.getCachDung());
        p.setMaThuoc(phieuThuoc.getMaThuoc().getMaThuoc());
        p.setMaPk(phieuThuoc.getMaPK().getMaPK());
        return p;
    }
    public List<PhieuThuocDTO> tolistDTO (List<PhieuThuoc> phieuThuocs)
    {
        List<PhieuThuocDTO> phieuThuocDTOS = new ArrayList<>();
        for(PhieuThuoc p: phieuThuocs)
        {
            PhieuThuocDTO todto = toDTO(p);
            phieuThuocDTOS.add(todto);
        }
        return phieuThuocDTOS;
    }
    public PhieuThuoc toEntity (PhieuThuocDTO phieuThuoc)
    {
        PhieuThuoc p = new PhieuThuoc();
        p.setMaPKThuoc(phieuThuoc.getMaPkThuoc());
        p.setSoLuong(phieuThuoc.getSoLuong());
        p.setCachDung(phieuThuoc.getCachDung());
        return p;
    }
    @Override
    public List<PhieuThuocDTO> getListPT() {
        List<PhieuThuoc> list = phieuThuocRepository.getListPT();
        return tolistDTO(list);
    }

    @Override
    public PhieuThuocDTO addPhieuThuoc(PhieuThuocDTO phieuThuocDTO) {
        PhieuThuoc phieuThuoc = new PhieuThuoc();
        phieuThuoc = toEntity(phieuThuocDTO);
        Thuoc thuoc = thuocrepository.getThuocById(phieuThuocDTO.getMaThuoc());
        phieuThuoc.setMaThuoc(thuoc);
        PhieuKham phieuKham = phieuKhamRepository.getPKById(phieuThuocDTO.getMaPk());
        phieuThuoc.setMaPK(phieuKham);
        phieuThuoc = phieuThuocRepository.addPhieuThuoc(phieuThuoc);
        return toDTO(phieuThuoc);
    }
}
