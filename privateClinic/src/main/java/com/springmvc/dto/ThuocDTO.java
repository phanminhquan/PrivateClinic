package com.springmvc.dto;

import org.springframework.web.multipart.MultipartFile;

public class ThuocDTO {
    private Long maThuoc;
    private String tenThuoc;
    private String moTa;
    private Integer soLuong;
    private Float giaBan;
    private Boolean isActive;
    private String donVi;
    private String hinhAnh;

    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public Long getMaThuoc() {
        return this.maThuoc;
    }

    public void setMaThuoc(Long maThuoc) {
        this.maThuoc = maThuoc;
    }

    public String getTenThuoc() {
        return this.tenThuoc;
    }

    public void setTenThuoc(String tenThuoc) {
        this.tenThuoc = tenThuoc;
    }

    public String getMoTa() {
        return this.moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Integer getSoLuong() {
        return this.soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Float getGiaBan() {
        return this.giaBan;
    }

    public void setGiaBan(Float giaBan) {
        this.giaBan = giaBan;
    }

    public Boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getDonVi() {
        return this.donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public String getHinhAnh() {
        return this.hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
