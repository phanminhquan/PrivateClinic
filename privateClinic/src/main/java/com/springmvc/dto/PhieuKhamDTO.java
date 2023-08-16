package com.springmvc.dto;

import com.springmvc.pojo.BenhNhan;

import java.util.Date;

public class PhieuKhamDTO {
    private Long maPk;
    private String ngayKham;
    private String trieuChung;
    private String chuanDoan;
    private Long maBn;
    private Boolean xacnhan;

    private Long maBS;

    public Long getMaBS() {
        return maBS;
    }

    public void setMaBS(Long maBS) {
        this.maBS = maBS;
    }

    public Long getMaPk() {
        return this.maPk;
    }

    public void setMaPk(Long maPk) {
        this.maPk = maPk;
    }

    public String getNgayKham() {
        return this.ngayKham;
    }

    public void setNgayKham(String ngayKham) {
        this.ngayKham = ngayKham;
    }

    public String getTrieuChung() {
        return this.trieuChung;
    }

    public void setTrieuChung(String trieuChung) {
        this.trieuChung = trieuChung;
    }

    public String getChuanDoan() {
        return this.chuanDoan;
    }

    public void setChuanDoan(String chuanDoan) {
        this.chuanDoan = chuanDoan;
    }

    public Long getMaBn() {
        return this.maBn;
    }

    public void setMaBn(Long maBn) {
        this.maBn = maBn;
    }

    public Boolean getXacnhan() {
        return this.xacnhan;
    }

    public void setXacnhan(Boolean xacnhan) {
        this.xacnhan = xacnhan;
    }
}
