package com.springmvc.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.springmvc.dto.BenhNhanDTO;
import com.springmvc.pojo.BenhNhan;
import com.springmvc.pojo.TaiKhoan;
import com.springmvc.repository.BenhNhanRepository;
import com.springmvc.repository.TaiKhoanRepository;
import com.springmvc.service.BenhNhanService;
import com.springmvc.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class BenhNhanServiceImpl implements BenhNhanService {
    @Autowired
    private BenhNhanRepository benhNhanRepository;
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;
    @Autowired
    Cloudinary cloudinary;

    public BenhNhanDTO toDTO(BenhNhan benhNhan) {
        BenhNhanDTO b = new BenhNhanDTO();
        b.setMaBn(benhNhan.getMaBN());
        b.setHoTen(benhNhan.getHoTen());
        b.setDienThoai(benhNhan.getDienThoai());
        b.setEmail(benhNhan.getEmail());
        b.setNgaySinh(benhNhan.getNgaySinh());
        b.setGioiTinh(benhNhan.getGioiTinh());
        b.setDiaChi(benhNhan.getDiaChi());
        b.setAvatar(benhNhan.getAvatar());
        b.setIdTk(benhNhan.getIdTk().getId());
        b.setFile(benhNhan.getFile());
        return b;
    }

    public BenhNhan toEntity(BenhNhanDTO benhNhan) {
        BenhNhan b = new BenhNhan();
        b.setMaBN(benhNhan.getMaBn());
        b.setHoTen(benhNhan.getHoTen());
        b.setDienThoai(benhNhan.getDienThoai());
        b.setEmail(benhNhan.getEmail());
        b.setNgaySinh(benhNhan.getNgaySinh());
        b.setGioiTinh(benhNhan.getGioiTinh());
        b.setDiaChi(benhNhan.getDiaChi());
        b.setAvatar(benhNhan.getAvatar());
        b.setFile(benhNhan.getFile());
        return b;
    }

    public List<BenhNhanDTO> tolistDto(List<BenhNhan> benhNhans) {
        List<BenhNhanDTO> list = new ArrayList<>();
        for (BenhNhan bennNhan : benhNhans) {
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
    public List<BenhNhanDTO> getALL(Map<String, String> params) {
        List<BenhNhan> list = benhNhanRepository.getALL(params);
        return tolistDto(list);
    }

    @Override
    public BenhNhanDTO getBNById(long id) {
        BenhNhan benhNhan = benhNhanRepository.getBenhNhanByID(id);
        return toDTO(benhNhan);
    }

    @Override
    public BenhNhanDTO addBenhNhan(BenhNhanDTO benhNhanDTO) {
        BenhNhan benhNhan = new BenhNhan();
        benhNhan = toEntity(benhNhanDTO);
        TaiKhoan tk = taiKhoanRepository.getTKById(benhNhanDTO.getIdTk());
        benhNhan.setIdTk(tk);
        if (!benhNhan.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(benhNhan.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                benhNhan.setAvatar(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(TaiKhoanService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        benhNhan = benhNhanRepository.addBenhNhan(benhNhan);
        return toDTO(benhNhan);
    }

}
