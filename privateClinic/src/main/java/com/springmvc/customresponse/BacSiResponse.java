package com.springmvc.customresponse;

import java.util.Date;

public class BacSiResponse {
    private Long maBs;
    private String chungChi;
    private String chuyenMon;
    private String hoTen;
    private String email;
    private Date ngaySinh;
    private String diaChi;

    public Long getMaBs() {
        return maBs;
    }

    public void setMaBs(Long maBs) {
        this.maBs = maBs;
    }

    public String getChungChi() {
        return chungChi;
    }

    public void setChungChi(String chungChi) {
        this.chungChi = chungChi;
    }

    public String getChuyenMon() {
        return chuyenMon;
    }

    public void setChuyenMon(String chuyenMon) {
        this.chuyenMon = chuyenMon;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public BacSiResponse(Long maBs, String chungChi, String chuyenMon, String hoTen, String email, Date ngaySinh, String diaChi, String dienThoai, String hinhAnh) {
        this.maBs = maBs;
        this.chungChi = chungChi;
        this.chuyenMon = chuyenMon;
        this.hoTen = hoTen;
        this.email = email;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.dienThoai = dienThoai;
        this.hinhAnh = hinhAnh;
    }

    private String dienThoai;
    private String hinhAnh;

}
