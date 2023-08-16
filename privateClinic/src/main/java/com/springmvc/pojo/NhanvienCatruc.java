package com.springmvc.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "nhanvien_catruc")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "NhanvienCatruc.findAll", query = "SELECT n FROM NhanvienCatruc n"),
        @NamedQuery(name = "NhanvienCatruc.findByMaNVCT", query = "SELECT n FROM NhanvienCatruc n WHERE n.maNVCT = :maNVCT")})

public class NhanvienCatruc {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "maNV_CT")
    private Integer maNVCT;
    @JoinColumn(name = "id_CT", referencedColumnName = "id")
    @ManyToOne
    private CaTrucTrongTuan idCT;
    @JoinColumn(name = "id_NV", referencedColumnName = "maNV")
    @ManyToOne
    private NhanVien idNV;


    public NhanvienCatruc(Integer maNVCT, CaTrucTrongTuan idCT, NhanVien idNV) {
        this.maNVCT = maNVCT;
        this.idCT = idCT;
        this.idNV = idNV;
    }

    public NhanvienCatruc() {

    }

    public Integer getMaNVCT() {
        return maNVCT;
    }

    public void setMaNVCT(Integer maNVCT) {
        this.maNVCT = maNVCT;
    }

    public CaTrucTrongTuan getIdCT() {
        return idCT;
    }

    public void setIdCT(CaTrucTrongTuan idCT) {
        this.idCT = idCT;
    }

    public NhanVien getIdNV() {
        return idNV;
    }

    public void setIdNV(NhanVien idNV) {
        this.idNV = idNV;
    }




    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maNVCT != null ? maNVCT.hashCode() : 0);
        return hash;
    }



    @Override
    public String toString() {
        return "com.springmvc.pojo.NhanvienCatruc[ maNVCT=" + maNVCT + " ]";
    }
}
