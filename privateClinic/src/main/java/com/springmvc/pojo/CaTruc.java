/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springmvc.pojo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "ca_truc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CaTruc.findAll", query = "SELECT c FROM CaTruc c"),
    @NamedQuery(name = "CaTruc.findByMaCT", query = "SELECT c FROM CaTruc c WHERE c.maCT = :maCT"),
    @NamedQuery(name = "CaTruc.findByGioTruc", query = "SELECT c FROM CaTruc c WHERE c.gioTruc = :gioTruc")})
public class CaTruc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "maCT")
    private Integer maCT;
    @Column(name = "gioTruc")
    @Temporal(TemporalType.TIME)
    private Date gioTruc;
    @OneToMany(mappedBy = "idCT")
    private Set<NhanvienCatruc> nhanvienCatrucSet;

    public CaTruc() {
    }

    public CaTruc(Integer maCT) {
        this.maCT = maCT;
    }

    public Integer getMaCT() {
        return maCT;
    }

    public void setMaCT(Integer maCT) {
        this.maCT = maCT;
    }

    public Date getGioTruc() {
        return gioTruc;
    }

    public void setGioTruc(Date gioTruc) {
        this.gioTruc = gioTruc;
    }

    @XmlTransient
    public Set<NhanvienCatruc> getNhanvienCatrucSet() {
        return nhanvienCatrucSet;
    }

    public void setNhanvienCatrucSet(Set<NhanvienCatruc> nhanvienCatrucSet) {
        this.nhanvienCatrucSet = nhanvienCatrucSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maCT != null ? maCT.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CaTruc)) {
            return false;
        }
        CaTruc other = (CaTruc) object;
        if ((this.maCT == null && other.maCT != null) || (this.maCT != null && !this.maCT.equals(other.maCT))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.springmvc.pojo.CaTruc[ maCT=" + maCT + " ]";
    }
    
}
