package com.springmvc.dto;

public class NhanvienCatrucDTO {
    private Integer maNvCt;
    private Integer idCt;
    private Long idNv;

    public Integer getMaNvCt() {
        return this.maNvCt;
    }

    public void setMaNvCt(Integer maNvCt) {
        this.maNvCt = maNvCt;
    }

    public Integer getIdCt() {
        return this.idCt;
    }

    public void setIdCt(Integer idCt) {
        this.idCt = idCt;
    }

    public Long getIdNv() {
        return this.idNv;
    }

    public void setIdNv(Long idNv) {
        this.idNv = idNv;
    }
}
