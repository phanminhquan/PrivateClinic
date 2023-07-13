/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springmvc.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "phieu_kham")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "PhieuKham.findAll", query = "SELECT p FROM PhieuKham p"),
        @NamedQuery(name = "PhieuKham.findByMaPK", query = "SELECT p FROM PhieuKham p WHERE p.maPK = :maPK"),
        @NamedQuery(name = "PhieuKham.findByNgayKham", query = "SELECT p FROM PhieuKham p WHERE p.ngayKham = :ngayKham"),
        @NamedQuery(name = "PhieuKham.findByXacnhan", query = "SELECT p FROM PhieuKham p WHERE p.xacnhan = :xacnhan")})
public class PhieuKham implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "maPK")
    private Long maPK;
    @Column(name = "ngayKham")
    @Temporal(TemporalType.DATE)
    private Date ngayKham;
    @Lob
    @Size(max = 65535)
    @Column(name = "trieuChung")
    private String trieuChung;
    @Lob
    @Size(max = 65535)
    @Column(name = "chuanDoan")
    private String chuanDoan;
    @Column(name = "xacnhan")
    private Short xacnhan;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maPK")
    private Set<PhieuThuoc> phieuThuocSet;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "maPK")
    private HoaDon hoaDon;
    @JoinColumn(name = "maBN", referencedColumnName = "maBN")
    @ManyToOne
    private BenhNhan maBN;

    public PhieuKham() {
    }

    public PhieuKham(Long maPK) {
        this.maPK = maPK;
    }

    public Long getMaPK() {
        return maPK;
    }

    public void setMaPK(Long maPK) {
        this.maPK = maPK;
    }

    public Date getNgayKham() {
        return ngayKham;
    }

    public void setNgayKham(Date ngayKham) {
        this.ngayKham = ngayKham;
    }

    public String getTrieuChung() {
        return trieuChung;
    }

    public void setTrieuChung(String trieuChung) {
        this.trieuChung = trieuChung;
    }

    public String getChuanDoan() {
        return chuanDoan;
    }

    public void setChuanDoan(String chuanDoan) {
        this.chuanDoan = chuanDoan;
    }

    public Short getXacnhan() {
        return xacnhan;
    }

    public void setXacnhan(Short xacnhan) {
        this.xacnhan = xacnhan;
    }

    @XmlTransient
    public Set<PhieuThuoc> getPhieuThuocSet() {
        return phieuThuocSet;
    }

    public void setPhieuThuocSet(Set<PhieuThuoc> phieuThuocSet) {
        this.phieuThuocSet = phieuThuocSet;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public BenhNhan getMaBN() {
        return maBN;
    }

    public void setMaBN(BenhNhan maBN) {
        this.maBN = maBN;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maPK != null ? maPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PhieuKham)) {
            return false;
        }
        PhieuKham other = (PhieuKham) object;
        if ((this.maPK == null && other.maPK != null) || (this.maPK != null && !this.maPK.equals(other.maPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.springmvc.pojo.PhieuKham[ maPK=" + maPK + " ]";
    }

}
