package com.springmvc.service.impl;

import com.springmvc.dto.BacSiDTO;
import com.springmvc.dto.NhanVienDTO;
import com.springmvc.pojo.BacSi;
import com.springmvc.pojo.NhanVien;
import com.springmvc.repository.NhanVienRepository;
import com.springmvc.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NhanVienServiceImpl implements NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;
    public NhanVienDTO toDto (NhanVien nhanVien)
    {
        NhanVienDTO nv = new NhanVienDTO();
        if(nhanVien.getMaNV() != null) {
            nv.setMaNv(nhanVien.getMaNV());
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
}
