package com.springmvc.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.springmvc.dto.NhanVienDTO;
import com.springmvc.pojo.NhanVien;
import com.springmvc.pojo.UserRole;
import com.springmvc.repository.NhanVienRepository;
import com.springmvc.service.NhanVienService;
import com.springmvc.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class NhanVienServiceImpl implements NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;
    @Autowired
    private Cloudinary cloudinary;
    public NhanVienDTO toDto (NhanVien nhanVien)
    {
        NhanVienDTO nv = new NhanVienDTO();
        nv.setMaNv(nhanVien.getMaNV());
        nv.setHoTen(nhanVien.getHoTen());
        nv.setEmail(nhanVien.getEmail());
        nv.setNgaySinh(nhanVien.getNgaySinh().toString());
        nv.setDiaChi(nhanVien.getDiaChi());
        nv.setDienThoai(nhanVien.getDienThoai());
        nv.setHinhAnh(nhanVien.getHinhAnh());
        nv.setIdUser(nhanVien.getIdUser().getId());
        nv.setFile(nhanVien.getFile());
        return nv;
    }
    public NhanVien toEntity (NhanVienDTO nhanVien) throws ParseException {
        NhanVien nv = new NhanVien();
        if(nhanVien.getMaNv() != null) {
            nv.setMaNV(nhanVien.getMaNv());
        }
        nv.setHoTen(nhanVien.getHoTen());
        nv.setEmail(nhanVien.getEmail());

        String year = nhanVien.getNgaySinh().substring(0,4);
        String month = nhanVien.getNgaySinh().substring(5,7);
        String date = nhanVien.getNgaySinh().substring(8,10);
        String createDate = date.concat("/").concat(month).concat("/").concat(year);
        Date d =  Utils.dateParse(createDate);

        nv.setNgaySinh(d);
        nv.setDiaChi(nhanVien.getDiaChi());
        nv.setDienThoai(nhanVien.getDienThoai());
        nv.setHinhAnh(nhanVien.getHinhAnh());
        nv.setFile(nhanVien.getFile());
        return nv;
    }
    @Override
    public NhanVienDTO getNhanVienById(long id) {
        return toDto(nhanVienRepository.getNhanVienById(id));
    }

    public List<NhanVienDTO> toNhanVienDto(List<NhanVien> nv)
    {
        List<NhanVienDTO> nhanVienDTOS = new ArrayList<>();
        for (NhanVien nhanVien : nv)
        {
            NhanVienDTO nvdto = toDto(nhanVien);
            nhanVienDTOS.add(nvdto);
        }
        return nhanVienDTOS;
    }
    @Override
    public List<NhanVienDTO> getListNV() {
        List<NhanVien> nv = nhanVienRepository.getListNV();
        return toNhanVienDto(nv);
    }

    @Override
    public List<NhanVienDTO> getListBS(Map<String , String> params) {
        List<NhanVien> nv = nhanVienRepository.getListBS(params);
        return toNhanVienDto(nv);
    }

    @Override
    public List<NhanVienDTO> getListYT(Map<String , String> params) {
        List<NhanVien> nv = nhanVienRepository.getListYT(params);
        return toNhanVienDto(nv);
    }

    @Override
    public NhanVienDTO addOrUpdateYta(NhanVienDTO nhanVienDTO) throws ParseException {
        NhanVien nhanVien = new NhanVien();
        nhanVien = toEntity(nhanVienDTO);
        UserRole userRole = nhanVienRepository.findUserRoleById(2);
        nhanVien.setIdUser(userRole);

        if (!nhanVien.getFile().isEmpty()){
            try {
                Map res =  this.cloudinary.uploader().upload(nhanVien.getFile().getBytes(), ObjectUtils.asMap("resource_type","auto"));
                nhanVien.setHinhAnh(res.get("secure_url").toString());
            }catch (IOException ex) {
                Logger.getLogger(NhanVienServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        nhanVien = nhanVienRepository.addOrUpdateNhanVien(nhanVien);
        return toDto(nhanVien);
    }

    @Override
    public NhanVienDTO addOrUpdateBacSi(NhanVienDTO nhanVienDTO) throws ParseException {
        NhanVien nhanVien = new NhanVien();
        nhanVien = toEntity(nhanVienDTO);
        UserRole userRole = nhanVienRepository.findUserRoleById(1);
        nhanVien.setIdUser(userRole);
        if (!nhanVien.getFile().isEmpty()){
            try {
                Map res =  this.cloudinary.uploader().upload(nhanVien.getFile().getBytes(), ObjectUtils.asMap("resource_type","auto"));
                nhanVien.setHinhAnh(res.get("secure_url").toString());
            }catch (IOException ex) {
                Logger.getLogger(NhanVienServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        nhanVien = nhanVienRepository.addOrUpdateNhanVien(nhanVien);

        return toDto(nhanVien);
    }


    @Override
    public void deleteNhanVien(Long id) {

        nhanVienRepository.deleteNhanVien(id);
    }

    @Override
    public List<NhanVienDTO> searchBS(String kw) {
        List<NhanVien> nv = nhanVienRepository.searchBS(kw);
        return toNhanVienDto(nv);
    }

    @Override
    public List<NhanVienDTO> searchYT(String kw) {
        List<NhanVien> nv = nhanVienRepository.searchYT(kw);
        return toNhanVienDto(nv);
    }

    @Override
    public Long countPromotion(long in) {
        return nhanVienRepository.countPromotion(in);
    }

}
