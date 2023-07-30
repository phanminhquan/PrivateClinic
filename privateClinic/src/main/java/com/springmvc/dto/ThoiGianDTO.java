package com.springmvc.dto;

import java.sql.Time;

public class ThoiGianDTO {
    private Long maTg;
    private Time gio;

    public Long getMaTg() {
        return this.maTg;
    }

    public void setMaTg(Long maTg) {
        this.maTg = maTg;
    }

    public Time getGio() {
        return this.gio;
    }

    public void setGio(Time gio) {
        this.gio = gio;
    }
}
