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
@Table(name = "ds_kham_benh")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DsKhamBenh.findAll", query = "SELECT d FROM DsKhamBenh d"),
    @NamedQuery(name = "DsKhamBenh.findByMaDS", query = "SELECT d FROM DsKhamBenh d WHERE d.maDS = :maDS"),
    @NamedQuery(name = "DsKhamBenh.findByNgayKham", query = "SELECT d FROM DsKhamBenh d WHERE d.ngayKham = :ngayKham")})
public class DsKhamBenh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "maDS")
    private Long maDS;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ngayKham")
    @Temporal(TemporalType.DATE)
    private Date ngayKham;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maDS")
    private Set<CtDsKham> ctDsKhamSet;

    public DsKhamBenh() {
    }

    public DsKhamBenh(Long maDS) {
        this.maDS = maDS;
    }

    public DsKhamBenh(Long maDS, Date ngayKham) {
        this.maDS = maDS;
        this.ngayKham = ngayKham;
    }

    public Long getMaDS() {
        return maDS;
    }

    public void setMaDS(Long maDS) {
        this.maDS = maDS;
    }

    public Date getNgayKham() {
        return ngayKham;
    }

    public void setNgayKham(Date ngayKham) {
        this.ngayKham = ngayKham;
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
        hash += (maDS != null ? maDS.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DsKhamBenh)) {
            return false;
        }
        DsKhamBenh other = (DsKhamBenh) object;
        if ((this.maDS == null && other.maDS != null) || (this.maDS != null && !this.maDS.equals(other.maDS))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.springmvc.pojo.DsKhamBenh[ maDS=" + maDS + " ]";
    }
    
}
