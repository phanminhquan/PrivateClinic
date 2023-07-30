/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springmvc.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "tai_khoan_role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TaiKhoanRole.findAll", query = "SELECT t FROM TaiKhoanRole t"),
    @NamedQuery(name = "TaiKhoanRole.findById", query = "SELECT t FROM TaiKhoanRole t WHERE t.id = :id"),
    @NamedQuery(name = "TaiKhoanRole.findByTen", query = "SELECT t FROM TaiKhoanRole t WHERE t.ten = :ten")})
public class TaiKhoanRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Long id;
    @Size(max = 50)
    @Column(name = "Ten")
    private String ten;
    @OneToMany(mappedBy = "tkRole")
    private Set<TaiKhoan> taiKhoanSet;

    public TaiKhoanRole() {
    }

    public TaiKhoanRole(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @XmlTransient
    public Set<TaiKhoan> getTaiKhoanSet() {
        return taiKhoanSet;
    }

    public void setTaiKhoanSet(Set<TaiKhoan> taiKhoanSet) {
        this.taiKhoanSet = taiKhoanSet;
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
        if (!(object instanceof TaiKhoanRole)) {
            return false;
        }
        TaiKhoanRole other = (TaiKhoanRole) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.springmvc.pojo.TaiKhoanRole[ id=" + id + " ]";
    }
    
}
