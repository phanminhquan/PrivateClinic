package com.springmvc.dto;

import java.util.Date;

public class PhieuKhamDTO {
    private Long maPk;
    private Date ngayKham;
    private String trieuChung;
    private String chuanDoan;
    private Long maBn;
    private Byte xacnhan;

    public Long getMaPk() {
        return this.maPk;
    }

    public void setMaPk(Long maPk) {
        this.maPk = maPk;
    }

    public Date getNgayKham() {
        return this.ngayKham;
    }

    public void setNgayKham(Date ngayKham) {
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

    public Byte getXacnhan() {
        return this.xacnhan;
    }

    public void setXacnhan(Byte xacnhan) {
        this.xacnhan = xacnhan;
    }
}
