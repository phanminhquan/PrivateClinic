package com.springmvc.dto;

public class CtDsKhamDTO {
    private Long maCtds;
    private Long maBn;

    private Long maTg;
    private Integer trangthai;

    public Long getMaCtds() {
        return this.maCtds;
    }

    public void setMaCtds(Long maCtds) {
        this.maCtds = maCtds;
    }

    public Long getMaBn() {
        return this.maBn;
    }

    public void setMaBn(Long maBn) {
        this.maBn = maBn;
    }

    public Long getMaTg() {
        return this.maTg;
    }

    public void setMaTg(Long maTg) {
        this.maTg = maTg;
    }

    public Integer getTrangthai() {
        return this.trangthai;
    }

    public void setTrangthai(Integer trangthai) {
        this.trangthai = trangthai;
    }
}
