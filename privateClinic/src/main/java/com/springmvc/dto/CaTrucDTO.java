package com.springmvc.dto;

import java.sql.Time;

public class CaTrucDTO {
    private Integer maCt;
    private Time gioTruc;

    public Integer getMaCt() {
        return this.maCt;
    }

    public void setMaCt(Integer maCt) {
        this.maCt = maCt;
    }

    public Time getGioTruc() {
        return this.gioTruc;
    }

    public void setGioTruc(Time gioTruc) {
        this.gioTruc = gioTruc;
    }
}
