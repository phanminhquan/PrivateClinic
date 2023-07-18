package com.springmvc.dto;

import java.util.Date;

public class ThoiGianDTO {
    private Long maTg;
    private Date gio;

    public Long getMaTg() {
        return this.maTg;
    }

    public void setMaTg(Long maTg) {
        this.maTg = maTg;
    }

    public Date getGio() {
        return this.gio;
    }

    public void setGio(Date gio) {
        this.gio = gio;
    }
}
