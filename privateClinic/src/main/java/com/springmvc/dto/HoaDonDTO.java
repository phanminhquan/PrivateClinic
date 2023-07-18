package com.springmvc.dto;

import java.util.Date;

public class HoaDonDTO {
    private Long maHd;
    private Float tienThuoc;
    private Float tienKham;
    private Float tongTien;
    private Date createdDate;
    private Long maPk;

    public Long getMaHd() {
        return this.maHd;
    }

    public void setMaHd(Long maHd) {
        this.maHd = maHd;
    }

    public Float getTienThuoc() {
        return this.tienThuoc;
    }

    public void setTienThuoc(Float tienThuoc) {
        this.tienThuoc = tienThuoc;
    }

    public Float getTienKham() {
        return this.tienKham;
    }

    public void setTienKham(Float tienKham) {
        this.tienKham = tienKham;
    }

    public Float getTongTien() {
        return this.tongTien;
    }

    public void setTongTien(Float tongTien) {
        this.tongTien = tongTien;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Long getMaPk() {
        return this.maPk;
    }

    public void setMaPk(Long maPk) {
        this.maPk = maPk;
    }
}
