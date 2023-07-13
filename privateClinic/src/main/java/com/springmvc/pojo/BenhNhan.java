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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "benh_nhan")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "BenhNhan.findAll", query = "SELECT b FROM BenhNhan b"),
        @NamedQuery(name = "BenhNhan.findByMaBN", query = "SELECT b FROM BenhNhan b WHERE b.maBN = :maBN"),
        @NamedQuery(name = "BenhNhan.findByHoTen", query = "SELECT b FROM BenhNhan b WHERE b.hoTen = :hoTen"),
        @NamedQuery(name = "BenhNhan.findByDienThoai", query = "SELECT b FROM BenhNhan b WHERE b.dienThoai = :dienThoai"),
        @NamedQuery(name = "BenhNhan.findByEmail", query = "SELECT b FROM BenhNhan b WHERE b.email = :email"),
        @NamedQuery(name = "BenhNhan.findByNgaySinh", query = "SELECT b FROM BenhNhan b WHERE b.ngaySinh = :ngaySinh"),
        @NamedQuery(name = "BenhNhan.findByGioiTinh", query = "SELECT b FROM BenhNhan b WHERE b.gioiTinh = :gioiTinh"),
        @NamedQuery(name = "BenhNhan.findByDiaChi", query = "SELECT b FROM BenhNhan b WHERE b.diaChi = :diaChi"),
        @NamedQuery(name = "BenhNhan.findByAvatar", query = "SELECT b FROM BenhNhan b WHERE b.avatar = :avatar")})
public class BenhNhan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "maBN")
    private Long maBN;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "hoTen")
    private String hoTen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "dienThoai")
    private String dienThoai;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ngaySinh")
    @Temporal(TemporalType.DATE)
    private Date ngaySinh;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gioiTinh")
    private boolean gioiTinh;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "diaChi")
    private String diaChi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "avatar")
    private String avatar;
    @OneToMany(mappedBy = "maBN")
    private Set<PhieuKham> phieuKhamSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maBN")
    private Set<CtDsKham> ctDsKhamSet;

    public BenhNhan() {
    }

    public BenhNhan(Long maBN) {
        this.maBN = maBN;
    }

    public BenhNhan(Long maBN, String hoTen, String dienThoai, String email, Date ngaySinh, boolean gioiTinh, String diaChi, String avatar) {
        this.maBN = maBN;
        this.hoTen = hoTen;
        this.dienThoai = dienThoai;
        this.email = email;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.avatar = avatar;
    }

    public Long getMaBN() {
        return maBN;
    }

    public void setMaBN(Long maBN) {
        this.maBN = maBN;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @XmlTransient
    public Set<PhieuKham> getPhieuKhamSet() {
        return phieuKhamSet;
    }

    public void setPhieuKhamSet(Set<PhieuKham> phieuKhamSet) {
        this.phieuKhamSet = phieuKhamSet;
    }

    @XmlTransient
    public Set<CtDsKham> getCtDsKhamSet() {
        return ctDsKhamSet;
    }

    public void setCtDsKhamSet(Set<CtDsKham> ctDsKhamSet) {
        this.ctDsKhamSet = ctDsKhamSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maBN != null ? maBN.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BenhNhan)) {
            return false;
        }
        BenhNhan other = (BenhNhan) object;
        if ((this.maBN == null && other.maBN != null) || (this.maBN != null && !this.maBN.equals(other.maBN))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.springmvc.pojo.BenhNhan[ maBN=" + maBN + " ]";
    }

}
