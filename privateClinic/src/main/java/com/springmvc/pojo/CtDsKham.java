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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "ct_ds_kham")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CtDsKham.findAll", query = "SELECT c FROM CtDsKham c"),
    @NamedQuery(name = "CtDsKham.findByMaCTDS", query = "SELECT c FROM CtDsKham c WHERE c.maCTDS = :maCTDS"),
    @NamedQuery(name = "CtDsKham.findByTrangthai", query = "SELECT c FROM CtDsKham c WHERE c.trangthai = :trangthai")})
public class CtDsKham implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "maCTDS")
    private Long maCTDS;
    @Column(name = "trangthai")
    private Boolean trangthai;
    @JoinColumn(name = "maBN", referencedColumnName = "maBN")
    @ManyToOne(optional = false)
    private BenhNhan maBN;
    @JoinColumn(name = "maDS", referencedColumnName = "maDS")
    @ManyToOne(optional = false)
    private DsKhamBenh maDS;
    @JoinColumn(name = "maTG", referencedColumnName = "maTG")
    @ManyToOne(optional = false)
    private ThoiGian maTG;

    public CtDsKham() {
    }

    public CtDsKham(Long maCTDS) {
        this.maCTDS = maCTDS;
    }

    public Long getMaCTDS() {
        return maCTDS;
    }

    public void setMaCTDS(Long maCTDS) {
        this.maCTDS = maCTDS;
    }

    public Boolean getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(Boolean trangthai) {
        this.trangthai = trangthai;
    }

    public BenhNhan getMaBN() {
        return maBN;
    }

    public void setMaBN(BenhNhan maBN) {
        this.maBN = maBN;
    }

    public DsKhamBenh getMaDS() {
        return maDS;
    }

    public void setMaDS(DsKhamBenh maDS) {
        this.maDS = maDS;
    }

    public ThoiGian getMaTG() {
        return maTG;
    }

    public void setMaTG(ThoiGian maTG) {
        this.maTG = maTG;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maCTDS != null ? maCTDS.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CtDsKham)) {
            return false;
        }
        CtDsKham other = (CtDsKham) object;
        if ((this.maCTDS == null && other.maCTDS != null) || (this.maCTDS != null && !this.maCTDS.equals(other.maCTDS))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.springmvc.pojo.CtDsKham[ maCTDS=" + maCTDS + " ]";
    }
    
}
