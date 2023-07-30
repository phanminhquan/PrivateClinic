package com.springmvc.dto;

import java.util.Date;

public class NhanVienDTO {
    private Long maNv;
    private String hoTen;
    private String email;
    private Date ngaySinh;
    private String diaChi;
    private String dienThoai;
    private String hinhAnh;
    private Long idUser;

    public Long getMaNv() {
        return this.maNv;
    }

    public void setMaNv(Long maNv) {
        this.maNv = maNv;
    }

    public String getHoTen() {
        return this.hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getNgaySinh() {
        return this.ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return this.diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getDienThoai() {
        return this.dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getHinhAnh() {
        return this.hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public Long getIdUser() {
        return this.idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
}
