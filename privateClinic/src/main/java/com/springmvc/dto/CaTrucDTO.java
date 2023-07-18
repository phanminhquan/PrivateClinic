package com.springmvc.dto;

import java.util.Date;

public class CaTrucDTO {
    private Integer maCt;
    private Date gioTruc;

    public Integer getMaCt() {
        return this.maCt;
    }

    public void setMaCt(Integer maCt) {
        this.maCt = maCt;
    }

    public Date getGioTruc() {
        return this.gioTruc;
    }

    public void setGioTruc(Date gioTruc) {
        this.gioTruc = gioTruc;
    }
}
