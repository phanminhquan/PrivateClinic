package com.springmvc.dto;

public class QuiDinhDTO {
    private Long maQd;
    private String tenQd;
    private String giaTri;

    public Long getMaQd() {
        return this.maQd;
    }

    public void setMaQd(Long maQd) {
        this.maQd = maQd;
    }

    public String getTenQd() {
        return this.tenQd;
    }

    public void setTenQd(String tenQd) {
        this.tenQd = tenQd;
    }

    public String getGiaTri() {
        return this.giaTri;
    }

    public void setGiaTri(String giaTri) {
        this.giaTri = giaTri;
    }
}
