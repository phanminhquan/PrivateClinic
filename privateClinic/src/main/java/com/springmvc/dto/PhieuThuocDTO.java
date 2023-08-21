package com.springmvc.dto;

public class PhieuThuocDTO {
    private Long maPkThuoc;

    private Integer soLuong;

    private String cachDung;

    private Long maThuoc;

    private Long maPk;

    public Long getMaPkThuoc() {
        return this.maPkThuoc;
    }

    public void setMaPkThuoc(Long maPkThuoc) {
        this.maPkThuoc = maPkThuoc;
    }

    public Integer getSoLuong() {
        return this.soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public String getCachDung() {
        return this.cachDung;
    }

    public void setCachDung(String cachDung) {
        this.cachDung = cachDung;
    }

    public Long getMaThuoc() {
        return this.maThuoc;
    }

    public void setMaThuoc(Long maThuoc) {
        this.maThuoc = maThuoc;
    }

    public Long getMaPk() {
        return this.maPk;
    }

    public void setMaPk(Long maPk) {
        this.maPk = maPk;
    }
}
