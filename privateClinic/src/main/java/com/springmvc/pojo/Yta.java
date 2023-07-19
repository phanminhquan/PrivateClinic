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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "yta")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Yta.findAll", query = "SELECT y FROM Yta y"),
        @NamedQuery(name = "Yta.findByMaYT", query = "SELECT y FROM Yta y WHERE y.maYT = :maYT"),
        @NamedQuery(name = "Yta.findByBangCap", query = "SELECT y FROM Yta y WHERE y.bangCap = :bangCap")})
public class Yta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "maYT")
    private Long maYT;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "BangCap")
    private String bangCap;
    @JoinColumn(name = "maNV", referencedColumnName = "maNV")
    @ManyToOne
    private NhanVien maNV;

    public Yta() {
    }

    public Yta(Long maYT) {
        this.maYT = maYT;
    }

    public Yta(Long maYT, String bangCap) {
        this.maYT = maYT;
        this.bangCap = bangCap;
    }

    public Long getMaYT() {
        return maYT;
    }

    public void setMaYT(Long maYT) {
        this.maYT = maYT;
    }

    public String getBangCap() {
        return bangCap;
    }

    public void setBangCap(String bangCap) {
        this.bangCap = bangCap;
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
        hash += (maYT != null ? maYT.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Yta)) {
            return false;
        }
        Yta other = (Yta) object;
        if ((this.maYT == null && other.maYT != null) || (this.maYT != null && !this.maYT.equals(other.maYT))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.springmvc.pojo.Yta[ maYT=" + maYT + " ]";
    }

}
