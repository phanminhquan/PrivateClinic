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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "thoi_gian")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "ThoiGian.findAll", query = "SELECT t FROM ThoiGian t"),
        @NamedQuery(name = "ThoiGian.findByMaTG", query = "SELECT t FROM ThoiGian t WHERE t.maTG = :maTG"),
        @NamedQuery(name = "ThoiGian.findByGio", query = "SELECT t FROM ThoiGian t WHERE t.gio = :gio")})
public class ThoiGian implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "maTG")
    private Long maTG;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gio")
    @Temporal(TemporalType.TIME)
    private Date gio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maTG")
    private Set<CtDsKham> ctDsKhamSet;

    public ThoiGian() {
    }

    public ThoiGian(Long maTG) {
        this.maTG = maTG;
    }

    public ThoiGian(Long maTG, Date gio) {
        this.maTG = maTG;
        this.gio = gio;
    }

    public Long getMaTG() {
        return maTG;
    }

    public void setMaTG(Long maTG) {
        this.maTG = maTG;
    }

    public Date getGio() {
        return gio;
    }

    public void setGio(Date gio) {
        this.gio = gio;
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
        hash += (maTG != null ? maTG.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ThoiGian)) {
            return false;
        }
        ThoiGian other = (ThoiGian) object;
        if ((this.maTG == null && other.maTG != null) || (this.maTG != null && !this.maTG.equals(other.maTG))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.springmvc.pojo.ThoiGian[ maTG=" + maTG + " ]";
    }

}
