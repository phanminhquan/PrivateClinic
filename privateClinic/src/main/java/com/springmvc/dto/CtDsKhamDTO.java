package com.springmvc.dto;

public class CtDsKhamDTO {
    private Long maCtds;
    private Long maBn;
    private Long maDs;
    private Long maTg;
    private Byte trangthai;

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

    public Long getMaDs() {
        return this.maDs;
    }

    public void setMaDs(Long maDs) {
        this.maDs = maDs;
    }

    public Long getMaTg() {
        return this.maTg;
    }

    public void setMaTg(Long maTg) {
        this.maTg = maTg;
    }

    public Byte getTrangthai() {
        return this.trangthai;
    }

    public void setTrangthai(Byte trangthai) {
        this.trangthai = trangthai;
    }
}
