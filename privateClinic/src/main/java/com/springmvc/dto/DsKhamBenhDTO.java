package com.springmvc.dto;

import java.util.Date;

public class DsKhamBenhDTO {
    private Long maDs;
    private Date ngayKham;

    public Long getMaDs() {
        return this.maDs;
    }

    public void setMaDs(Long maDs) {
        this.maDs = maDs;
    }

    public Date getNgayKham() {
        return this.ngayKham;
    }

    public void setNgayKham(Date ngayKham) {
        this.ngayKham = ngayKham;
    }
}
