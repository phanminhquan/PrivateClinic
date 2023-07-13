/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springmvc.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "bac_si")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "BacSi.findAll", query = "SELECT b FROM BacSi b"),
        @NamedQuery(name = "BacSi.findByMaBS", query = "SELECT b FROM BacSi b WHERE b.maBS = :maBS"),
        @NamedQuery(name = "BacSi.findByChungChi", query = "SELECT b FROM BacSi b WHERE b.chungChi = :chungChi"),
        @NamedQuery(name = "BacSi.findByChuyenMon", query = "SELECT b FROM BacSi b WHERE b.chuyenMon = :chuyenMon")})
public class BacSi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "maBS")
    private Long maBS;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "chungChi")
    private String chungChi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "chuyenMon")
    private String chuyenMon;
    @JoinColumn(name = "maBS", referencedColumnName = "maNV", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private NhanVien nhanVien;

    public BacSi() {
    }

    public BacSi(Long maBS) {
        this.maBS = maBS;
    }

    public BacSi(Long maBS, String chungChi, String chuyenMon) {
        this.maBS = maBS;
        this.chungChi = chungChi;
        this.chuyenMon = chuyenMon;
    }

    public Long getMaBS() {
        return maBS;
    }

    public void setMaBS(Long maBS) {
        this.maBS = maBS;
    }

    public String getChungChi() {
        return chungChi;
    }

    public void setChungChi(String chungChi) {
        this.chungChi = chungChi;
    }

    public String getChuyenMon() {
        return chuyenMon;
    }

    public void setChuyenMon(String chuyenMon) {
        this.chuyenMon = chuyenMon;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maBS != null ? maBS.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BacSi)) {
            return false;
        }
        BacSi other = (BacSi) object;
        if ((this.maBS == null && other.maBS != null) || (this.maBS != null && !this.maBS.equals(other.maBS))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.springmvc.pojo.BacSi[ maBS=" + maBS + " ]";
    }

}
