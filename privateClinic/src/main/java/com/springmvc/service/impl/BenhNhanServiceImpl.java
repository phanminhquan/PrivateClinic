package com.springmvc.service.impl;

import com.springmvc.dto.BenhNhanDTO;
import com.springmvc.pojo.BenhNhan;
import com.springmvc.repository.BenhNhanRepository;
import com.springmvc.service.BenhNhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BenhNhanServiceImpl implements BenhNhanService {
    @Autowired
    private BenhNhanRepository benhNhanRepository;

    public BenhNhanDTO toDTO (BenhNhan benhNhan)
    {
        BenhNhanDTO b = new BenhNhanDTO();
        b.setMaBn(benhNhan.getMaBN());
        b.setHoTen(benhNhan.getHoTen());
        b.setDienThoai(benhNhan.getDienThoai());
        b.setEmail(benhNhan.getEmail());
        b.setNgaySinh(benhNhan.getNgaySinh());
        b.setGioiTinh(benhNhan.getGioiTinh());
        b.setDiaChi(benhNhan.getDiaChi());
        b.setAvatar(benhNhan.getAvatar());
        return b;
    }

    public BenhNhan toEntity (BenhNhanDTO benhNhan)
    {
        BenhNhan b = new BenhNhan();
        b.setMaBN(benhNhan.getMaBn());
        b.setHoTen(benhNhan.getHoTen());
        b.setDienThoai(benhNhan.getDienThoai());
        b.setEmail(benhNhan.getEmail());
        b.setNgaySinh(benhNhan.getNgaySinh());
        b.setGioiTinh(benhNhan.getGioiTinh());
        b.setDiaChi(benhNhan.getDiaChi());
        b.setAvatar(benhNhan.getAvatar());
        return b;
    }
    public List<BenhNhanDTO> tolistDto (List<BenhNhan> benhNhans)
    {
        List<BenhNhanDTO> list = new ArrayList<>();
        for(BenhNhan bennNhan : benhNhans)
        {
            BenhNhanDTO dto = toDTO(bennNhan);
            list.add(dto);
        }
        return list;
    }
    @Override
    public List<BenhNhanDTO> SearchBN(String kw) {
        List<BenhNhan> list = benhNhanRepository.SearchBN(kw);
        return tolistDto(list);
    }

    @Override
    public List<BenhNhanDTO> getALL(Map<String,String> params) {
        List<BenhNhan> list = benhNhanRepository.getALL(params);
        return tolistDto(list);
    }

    @Override
    public BenhNhanDTO getBNById(long id) {
        BenhNhan benhNhan = benhNhanRepository.getBenhNhanByID(id);
        return toDTO(benhNhan);
    }

}
