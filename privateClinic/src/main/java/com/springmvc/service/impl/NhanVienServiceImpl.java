package com.springmvc.service.impl;

import com.springmvc.dto.NhanVienDTO;
import com.springmvc.pojo.NhanVien;
import com.springmvc.pojo.UserRole;
import com.springmvc.repository.NhanVienRepository;
import com.springmvc.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NhanVienServiceImpl implements NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;
    public NhanVienDTO toDto (NhanVien nhanVien)
    {
        NhanVienDTO nv = new NhanVienDTO();
        nv.setMaNv(nhanVien.getMaNV());
        nv.setHoTen(nhanVien.getHoTen());
        nv.setEmail(nhanVien.getEmail());
        nv.setNgaySinh(nhanVien.getNgaySinh());
        nv.setDiaChi(nhanVien.getDiaChi());
        nv.setDienThoai(nhanVien.getDienThoai());
        nv.setHinhAnh(nhanVien.getHinhAnh());
        nv.setIdUser(nhanVien.getIdUser().getId());
        return nv;
    }
    public NhanVien toEntity (NhanVienDTO nhanVien)
    {
        NhanVien nv = new NhanVien();
        if(nhanVien.getMaNv() != null) {
            nv.setMaNV(nhanVien.getMaNv());
        }
        nv.setHoTen(nhanVien.getHoTen());
        nv.setEmail(nhanVien.getEmail());
        nv.setNgaySinh(nhanVien.getNgaySinh());
        nv.setDiaChi(nhanVien.getDiaChi());
        nv.setDienThoai(nhanVien.getDienThoai());
        nv.setHinhAnh(nhanVien.getHinhAnh());
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
    public List<NhanVienDTO> getListBS() {
        List<NhanVien> nv = nhanVienRepository.getListBS();
        return toNhanVienDto(nv);
    }

    @Override
    public List<NhanVienDTO> getListYT() {
        List<NhanVien> nv = nhanVienRepository.getListYT();
        return toNhanVienDto(nv);
    }

    @Override
    public NhanVienDTO addOrUpdateNhanVien(NhanVienDTO nhanVienDTO) {
        NhanVien nhanVien = new NhanVien();
        nhanVien = toEntity(nhanVienDTO);
        UserRole userRole = nhanVienRepository.findUserRoleById(nhanVienDTO.getIdUser());
        nhanVien.setIdUser(userRole);
        nhanVien = nhanVienRepository.addOrUpdateNhanVien(nhanVien);
        return toDto(nhanVien);
    }

    @Override
    public void deleteNhanVien(Long id) {

        nhanVienRepository.deleteNhanVien(id);
    }

}
