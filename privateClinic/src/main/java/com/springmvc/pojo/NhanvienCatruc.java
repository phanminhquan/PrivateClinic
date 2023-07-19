/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springmvc.pojo;

import java.io.Serializable;
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

/**
 *
 * @author user
 */
@Entity
@Table(name = "nhanvien_catruc")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "NhanvienCatruc.findAll", query = "SELECT n FROM NhanvienCatruc n"),
        @NamedQuery(name = "NhanvienCatruc.findByMaNVCT", query = "SELECT n FROM NhanvienCatruc n WHERE n.maNVCT = :maNVCT")})
public class NhanvienCatruc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "maNV_CT")
    private Integer maNVCT;
    @JoinColumn(name = "id_CT", referencedColumnName = "maCT")
    @ManyToOne
    private CaTruc idCT;
    @JoinColumn(name = "id_NV", referencedColumnName = "maNV")
    @ManyToOne
    private NhanVien idNV;

    public NhanvienCatruc() {
    }

    public NhanvienCatruc(Integer maNVCT) {
        this.maNVCT = maNVCT;
    }

    public Integer getMaNVCT() {
        return maNVCT;
    }

    public void setMaNVCT(Integer maNVCT) {
        this.maNVCT = maNVCT;
    }

    public CaTruc getIdCT() {
        return idCT;
    }

    public void setIdCT(CaTruc idCT) {
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
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NhanvienCatruc)) {
            return false;
        }
        NhanvienCatruc other = (NhanvienCatruc) object;
        if ((this.maNVCT == null && other.maNVCT != null) || (this.maNVCT != null && !this.maNVCT.equals(other.maNVCT))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.springmvc.pojo.NhanvienCatruc[ maNVCT=" + maNVCT + " ]";
    }

}
