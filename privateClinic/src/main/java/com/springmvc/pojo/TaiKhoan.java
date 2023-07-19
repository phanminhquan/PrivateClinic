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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "tai_khoan")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "TaiKhoan.findAll", query = "SELECT t FROM TaiKhoan t"),
        @NamedQuery(name = "TaiKhoan.findById", query = "SELECT t FROM TaiKhoan t WHERE t.id = :id"),
        @NamedQuery(name = "TaiKhoan.findByName", query = "SELECT t FROM TaiKhoan t WHERE t.name = :name"),
        @NamedQuery(name = "TaiKhoan.findByUsername", query = "SELECT t FROM TaiKhoan t WHERE t.username = :username"),
        @NamedQuery(name = "TaiKhoan.findByPassword", query = "SELECT t FROM TaiKhoan t WHERE t.password = :password"),
        @NamedQuery(name = "TaiKhoan.findByAvatar", query = "SELECT t FROM TaiKhoan t WHERE t.avatar = :avatar"),
        @NamedQuery(name = "TaiKhoan.findByIsActive", query = "SELECT t FROM TaiKhoan t WHERE t.isActive = :isActive"),
        @NamedQuery(name = "TaiKhoan.findByUserRole", query = "SELECT t FROM TaiKhoan t WHERE t.userRole = :userRole")})
public class TaiKhoan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "password")
    private String password;
    @Size(max = 150)
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "is_active")
    private Boolean isActive;
    @Size(max = 6)
    @Column(name = "user_role")
    private String userRole;
    @JoinColumn(name = "maNV", referencedColumnName = "maNV")
    @OneToOne(optional = false)
    private NhanVien maNV;

    public TaiKhoan() {
    }

    public TaiKhoan(Long id) {
        this.id = id;
    }

    public TaiKhoan(Long id, String name, String username, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public NhanVien getMaNV() {
        return maNV;
    }

    public void setMaNV(NhanVien maNV) {
        this.maNV = maNV;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaiKhoan)) {
            return false;
        }
        TaiKhoan other = (TaiKhoan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.springmvc.pojo.TaiKhoan[ id=" + id + " ]";
    }

}
