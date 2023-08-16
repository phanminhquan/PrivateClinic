package com.springmvc.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.springmvc.dto.ThuocDTO;
import com.springmvc.pojo.Thuoc;
import com.springmvc.repository.Thuocrepository;
import com.springmvc.service.ThuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ThuocServiceImpl implements ThuocService {
    @Autowired
    private Thuocrepository thuocrepository;

    @Autowired
    private Cloudinary cloudinary;

    public ThuocDTO toDto(Thuoc thuoc) {
        ThuocDTO t = new ThuocDTO();
        t.setDonVi(thuoc.getDonVi());
        t.setMaThuoc(thuoc.getMaThuoc());
        t.setHinhAnh(thuoc.getHinhAnh());
        t.setMoTa(thuoc.getMoTa());
        t.setIsActive(thuoc.getIsActive());
        t.setGiaBan(thuoc.getGiaBan());
        t.setTenThuoc(thuoc.getTenThuoc());
        t.setSoLuong(thuoc.getSoLuong());
        t.setFile(thuoc.getFile());
        return t;
    }

    public Thuoc toEntity(ThuocDTO thuocDTO) {
        Thuoc t = new Thuoc();
        t.setDonVi(thuocDTO.getDonVi());
        if (thuocDTO.getMaThuoc() != null) {
            t.setMaThuoc(thuocDTO.getMaThuoc());
        }
        t.setHinhAnh(thuocDTO.getHinhAnh());
        t.setMoTa(thuocDTO.getMoTa());
        t.setIsActive(thuocDTO.getIsActive());
        t.setGiaBan(thuocDTO.getGiaBan());
        t.setTenThuoc(thuocDTO.getTenThuoc());
        t.setSoLuong(thuocDTO.getSoLuong());
        t.setFile(thuocDTO.getFile());
        return t;
    }

    public List<ThuocDTO> toThuocDTOList(List<Thuoc> t) {
        List<ThuocDTO> thuocDTOS = new ArrayList<>();
        for (Thuoc thuoc : t) {
            ThuocDTO dto = toDto(thuoc);
            if (dto.getIsActive() != false)
                thuocDTOS.add(dto);
        }
        return thuocDTOS;
    }

    @Override
    public List<ThuocDTO> getListThuoc(Map<String, String> params) {
        List<Thuoc> thuoc = thuocrepository.getListThuoc(params);
        return toThuocDTOList(thuoc);
    }

    @Override
    public ThuocDTO addOrUpdateThuoc(ThuocDTO thuocDTO) throws ParseException {
        Thuoc thuoc = new Thuoc();
        thuoc = toEntity(thuocDTO);
        if (!thuoc.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(thuoc.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                thuoc.setHinhAnh(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(NhanVienServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        thuoc = thuocrepository.addOrUpdateThuoc(thuoc);
        return toDto(thuoc);
    }


    @Override
    public ThuocDTO getThuocById(long id) {
        return toDto(thuocrepository.getThuocById(id));
    }

    @Override
    public void deleteThuoc(Long id) {
        thuocrepository.deleteThuoc(id);
    }

    @Override
    public List<ThuocDTO> searchThuoc(String kw) {
        List<Thuoc> thuoc = thuocrepository.searchThuoc(kw);
        return toThuocDTOList(thuoc);
    }

    @Override
    public Long countPromotion(long in) {
        return thuocrepository.countPromotion(in);
    }

    @Override
    public List<Object[]> getListByIDPK(long id) {
        return thuocrepository.getListThuocByPK(id);
    }
}
