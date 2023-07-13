/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springmvc.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "thuoc")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Thuoc.findAll", query = "SELECT t FROM Thuoc t"),
        @NamedQuery(name = "Thuoc.findByMaThuoc", query = "SELECT t FROM Thuoc t WHERE t.maThuoc = :maThuoc"),
        @NamedQuery(name = "Thuoc.findByTenThuoc", query = "SELECT t FROM Thuoc t WHERE t.tenThuoc = :tenThuoc"),
        @NamedQuery(name = "Thuoc.findBySoLuong", query = "SELECT t FROM Thuoc t WHERE t.soLuong = :soLuong"),
        @NamedQuery(name = "Thuoc.findByGiaBan", query = "SELECT t FROM Thuoc t WHERE t.giaBan = :giaBan"),
        @NamedQuery(name = "Thuoc.findByIsActive", query = "SELECT t FROM Thuoc t WHERE t.isActive = :isActive"),
        @NamedQuery(name = "Thuoc.findByDonVi", query = "SELECT t FROM Thuoc t WHERE t.donVi = :donVi"),
        @NamedQuery(name = "Thuoc.findByHinhAnh", query = "SELECT t FROM Thuoc t WHERE t.hinhAnh = :hinhAnh")})
public class Thuoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "maThuoc")
    private Long maThuoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "tenThuoc")
    private String tenThuoc;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "moTa")
    private String moTa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "soLuong")
    private int soLuong;
    @Basic(optional = false)
    @NotNull
    @Column(name = "giaBan")
    private float giaBan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_active")
    private boolean isActive;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "donVi")
    private String donVi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "hinhAnh")
    private String hinhAnh;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maThuoc")
    private Set<PhieuThuoc> phieuThuocSet;

    public Thuoc() {
    }

    public Thuoc(Long maThuoc) {
        this.maThuoc = maThuoc;
    }

    public Thuoc(Long maThuoc, String tenThuoc, String moTa, int soLuong, float giaBan, boolean isActive, String donVi, String hinhAnh) {
        this.maThuoc = maThuoc;
        this.tenThuoc = tenThuoc;
        this.moTa = moTa;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.isActive = isActive;
        this.donVi = donVi;
        this.hinhAnh = hinhAnh;
    }

    public Long getMaThuoc() {
        return maThuoc;
    }

    public void setMaThuoc(Long maThuoc) {
        this.maThuoc = maThuoc;
    }

    public String getTenThuoc() {
        return tenThuoc;
    }

    public void setTenThuoc(String tenThuoc) {
        this.tenThuoc = tenThuoc;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    @XmlTransient
    public Set<PhieuThuoc> getPhieuThuocSet() {
        return phieuThuocSet;
    }

    public void setPhieuThuocSet(Set<PhieuThuoc> phieuThuocSet) {
        this.phieuThuocSet = phieuThuocSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maThuoc != null ? maThuoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thuoc)) {
            return false;
        }
        Thuoc other = (Thuoc) object;
        if ((this.maThuoc == null && other.maThuoc != null) || (this.maThuoc != null && !this.maThuoc.equals(other.maThuoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.springmvc.pojo.Thuoc[ maThuoc=" + maThuoc + " ]";
    }

}
