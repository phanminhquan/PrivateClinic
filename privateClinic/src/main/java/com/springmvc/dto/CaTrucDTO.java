package com.springmvc.dto;

import java.sql.Time;

public class CaTrucDTO {
    private Integer maCt;
    private String gioTruc;
    private String gioKetThuc;


    public String getGioTruc() {
        return gioTruc;
    }

    public void setGioTruc(String gioTruc) {
        this.gioTruc = gioTruc;
    }

    public String getGioKetThuc() {
        return gioKetThuc;
    }

    public void setGioKetThuc(String gioKetThuc) {
        this.gioKetThuc = gioKetThuc;
    }

    public Integer getMaCt() {
        return this.maCt;
    }

    public void setMaCt(Integer maCt) {
        this.maCt = maCt;
    }




}
