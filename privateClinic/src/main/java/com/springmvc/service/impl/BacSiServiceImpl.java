package com.springmvc.service.impl;

import com.springmvc.customresponse.BacSiResponse;
import com.springmvc.dto.BacSiDTO;
import com.springmvc.pojo.BacSi;
import com.springmvc.pojo.NhanVien;
import com.springmvc.pojo.Thuoc;
import com.springmvc.repository.BacSiRepository;
import com.springmvc.service.BacSiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BacSiServiceImpl implements BacSiService {

    @Autowired
    private BacSiRepository bacSiRepository;

    public BacSiDTO toDto (BacSi bacSi)
    {
        BacSiDTO bs = new BacSiDTO();
        if(bacSi.getMaBS() != null) {
            bs.setMaBs(bacSi.getMaBS());
        }
        bs.setChungChi(bacSi.getChungChi());
        bs.setChuyenMon(bacSi.getChuyenMon());
        bs.setMaNv(bacSi.getMaNV().getMaNV());
        return bs;
    }

    public BacSi toEntity (BacSiDTO bacSi)
    {
        BacSi bs = new BacSi();
        bs.setMaBS(bacSi.getMaBs());
        bs.setChungChi(bacSi.getChungChi());
        bs.setChuyenMon(bacSi.getChuyenMon());
        return bs;
    }
    public BacSi toEntity (BacSiDTO bacSi, BacSi bs)
    {
        bs.setMaBS(bacSi.getMaBs());
        bs.setChungChi(bacSi.getChungChi());
        bs.setChuyenMon(bacSi.getChuyenMon());
        return bs;
    }
    public List<BacSiDTO> toBacSiDTO(List<BacSi> t) {
        List<BacSiDTO> bacSiDTOS = new ArrayList<>();
        for(BacSi bacSi: t)
        {
            BacSiDTO dto = toDto(bacSi);
            bacSiDTOS.add(dto);
        }
        return bacSiDTOS;
    }

    @Override
    public List<BacSiDTO> getListBS() {
        List<BacSi> bs = bacSiRepository.getListBS();
        return toBacSiDTO(bs);
    }

    @Override
    public BacSiDTO createBS(BacSiDTO bacSiDTO) {
        BacSi bacSi = new BacSi();
        bacSi = toEntity(bacSiDTO);
        NhanVien nhanVien = bacSiRepository.findUserById(bacSiDTO.getMaNv());
        bacSi.setMaNV(nhanVien);
        bacSi = bacSiRepository.createBS(bacSi);
        return toDto(bacSi);
    }

    @Override
    public void deleteBS(Long id) {
        bacSiRepository.deleteBS(id);
    }

    @Override
    public BacSiDTO updateBS(BacSiDTO bacSiDTO) {
        BacSi bacSi = new BacSi();
        bacSi = toEntity(bacSiDTO);
        NhanVien nhanVien = bacSiRepository.findUserById(bacSiDTO.getMaNv());
        bacSi.setMaNV(nhanVien);
        bacSi = bacSiRepository.updateBS(bacSi);
        return toDto(bacSi);
    }

    @Override
    public BacSiDTO findBSByID(Long id) {
        BacSi bs = bacSiRepository.findBacSiById(id);
        return toDto(bs);
    }

    @Override
    public List<Object[]> getList(Map<String, String> params) {
        return bacSiRepository.getListBacSi(params);
    }


    @Override
    public List<String> getAllChuyenMon() {
        List<BacSiDTO> list  = this.getListBS();
        List<String> listChuyenMon = new ArrayList<>();
        for(BacSiDTO b : list){
            if (!listChuyenMon.contains(b.getChuyenMon())){
                listChuyenMon.add(b.getChuyenMon());
            }
        }
        return  listChuyenMon;
    }
}
