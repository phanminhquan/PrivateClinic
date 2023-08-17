/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springmvc.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "hoa_don")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HoaDon.findAll", query = "SELECT h FROM HoaDon h"),
    @NamedQuery(name = "HoaDon.findByMaHD", query = "SELECT h FROM HoaDon h WHERE h.maHD = :maHD"),
    @NamedQuery(name = "HoaDon.findByTienThuoc", query = "SELECT h FROM HoaDon h WHERE h.tienThuoc = :tienThuoc"),
    @NamedQuery(name = "HoaDon.findByTienKham", query = "SELECT h FROM HoaDon h WHERE h.tienKham = :tienKham"),
    @NamedQuery(name = "HoaDon.findByTongTien", query = "SELECT h FROM HoaDon h WHERE h.tongTien = :tongTien"),
    @NamedQuery(name = "HoaDon.findByCreatedDate", query = "SELECT h FROM HoaDon h WHERE h.createdDate = :createdDate")})
public class HoaDon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "maHD")
    private Long maHD;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tienThuoc")
    private float tienThuoc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tienKham")
    private float tienKham;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tongTien")
    private float tongTien;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @JoinColumn(name = "maPK", referencedColumnName = "maPK")
    @OneToOne(optional = false)
    private PhieuKham maPK;

    public HoaDon() {
    }

    public HoaDon(Long maHD) {
        this.maHD = maHD;
    }

    public HoaDon(Long maHD, float tienThuoc, float tienKham, float tongTien, Date createdDate) {
        this.maHD = maHD;
        this.tienThuoc = tienThuoc;
        this.tienKham = tienKham;
        this.tongTien = tongTien;
        this.createdDate = createdDate;
    }

    public Long getMaHD() {
        return maHD;
    }

    public void setMaHD(Long maHD) {
        this.maHD = maHD;
    }

    public float getTienThuoc() {
        return tienThuoc;
    }

    public void setTienThuoc(float tienThuoc) {
        this.tienThuoc = tienThuoc;
    }

    public float getTienKham() {
        return tienKham;
    }

    public void setTienKham(float tienKham) {
        this.tienKham = tienKham;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public PhieuKham getMaPK() {
        return maPK;
    }

    public void setMaPK(PhieuKham maPK) {
        this.maPK = maPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maHD != null ? maHD.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HoaDon)) {
            return false;
        }
        HoaDon other = (HoaDon) object;
        if ((this.maHD == null && other.maHD != null) || (this.maHD != null && !this.maHD.equals(other.maHD))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.springmvc.pojo.HoaDon[ maHD=" + maHD + " ]";
    }
    
}
