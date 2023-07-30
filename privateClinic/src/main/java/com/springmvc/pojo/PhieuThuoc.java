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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "phieu_thuoc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PhieuThuoc.findAll", query = "SELECT p FROM PhieuThuoc p"),
    @NamedQuery(name = "PhieuThuoc.findByMaPKThuoc", query = "SELECT p FROM PhieuThuoc p WHERE p.maPKThuoc = :maPKThuoc"),
    @NamedQuery(name = "PhieuThuoc.findBySoLuong", query = "SELECT p FROM PhieuThuoc p WHERE p.soLuong = :soLuong"),
    @NamedQuery(name = "PhieuThuoc.findByCachDung", query = "SELECT p FROM PhieuThuoc p WHERE p.cachDung = :cachDung")})
public class PhieuThuoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "maPK_Thuoc")
    private Long maPKThuoc;
    @Column(name = "soLuong")
    private Integer soLuong;
    @Size(max = 300)
    @Column(name = "cachDung")
    private String cachDung;
    @JoinColumn(name = "maPK", referencedColumnName = "maPK")
    @ManyToOne(optional = false)
    private PhieuKham maPK;
    @JoinColumn(name = "maThuoc", referencedColumnName = "maThuoc")
    @ManyToOne(optional = false)
    private Thuoc maThuoc;

    public PhieuThuoc() {
    }

    public PhieuThuoc(Long maPKThuoc) {
        this.maPKThuoc = maPKThuoc;
    }

    public Long getMaPKThuoc() {
        return maPKThuoc;
    }

    public void setMaPKThuoc(Long maPKThuoc) {
        this.maPKThuoc = maPKThuoc;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public String getCachDung() {
        return cachDung;
    }

    public void setCachDung(String cachDung) {
        this.cachDung = cachDung;
    }

    public PhieuKham getMaPK() {
        return maPK;
    }

    public void setMaPK(PhieuKham maPK) {
        this.maPK = maPK;
    }

    public Thuoc getMaThuoc() {
        return maThuoc;
    }

    public void setMaThuoc(Thuoc maThuoc) {
        this.maThuoc = maThuoc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maPKThuoc != null ? maPKThuoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PhieuThuoc)) {
            return false;
        }
        PhieuThuoc other = (PhieuThuoc) object;
        if ((this.maPKThuoc == null && other.maPKThuoc != null) || (this.maPKThuoc != null && !this.maPKThuoc.equals(other.maPKThuoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.springmvc.pojo.PhieuThuoc[ maPKThuoc=" + maPKThuoc + " ]";
    }
    
}
