/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springmvc.pojo;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author user
 */
@Entity
@Table(name = "ca_truc_trong_tuan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CaTrucTrongTuan.findAll", query = "SELECT c FROM CaTrucTrongTuan c"),
    @NamedQuery(name = "CaTrucTrongTuan.findById", query = "SELECT c FROM CaTrucTrongTuan c WHERE c.id = :id")})
public class CaTrucTrongTuan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_ca_truc", referencedColumnName = "maCT")
    @ManyToOne
    private CaTruc idCaTruc;
    @JoinColumn(name = "id_ngay", referencedColumnName = "id")
    @ManyToOne
    private DateOfWeek idNgay;
    @OneToMany(mappedBy = "idCT")
    private Set<NhanvienCatruc> nhanvienCatrucSet;

    public CaTrucTrongTuan() {
    }

    public CaTrucTrongTuan(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CaTruc getIdCaTruc() {
        return idCaTruc;
    }

    public void setIdCaTruc(CaTruc idCaTruc) {
        this.idCaTruc = idCaTruc;
    }

    public DateOfWeek getIdNgay() {
        return idNgay;
    }

    public void setIdNgay(DateOfWeek idNgay) {
        this.idNgay = idNgay;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CaTrucTrongTuan)) {
            return false;
        }
        CaTrucTrongTuan other = (CaTrucTrongTuan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public CaTrucTrongTuan(Integer id, CaTruc idCaTruc, DateOfWeek idNgay) {
        this.id = id;
        this.idCaTruc = idCaTruc;
        this.idNgay = idNgay;
    }

    @Override
    public String toString() {
        return "com.springmvc.pojo.CaTrucTrongTuan[ id=" + id + " ]";
    }
    
}
