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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "qui_dinh")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "QuiDinh.findAll", query = "SELECT q FROM QuiDinh q"),
        @NamedQuery(name = "QuiDinh.findByMaQD", query = "SELECT q FROM QuiDinh q WHERE q.maQD = :maQD"),
        @NamedQuery(name = "QuiDinh.findByTenQD", query = "SELECT q FROM QuiDinh q WHERE q.tenQD = :tenQD"),
        @NamedQuery(name = "QuiDinh.findByGiaTri", query = "SELECT q FROM QuiDinh q WHERE q.giaTri = :giaTri")})
public class QuiDinh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "maQD")
    private Long maQD;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tenQD")
    private String tenQD;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "giaTri")
    private String giaTri;

    public QuiDinh() {
    }

    public QuiDinh(Long maQD) {
        this.maQD = maQD;
    }

    public QuiDinh(Long maQD, String tenQD, String giaTri) {
        this.maQD = maQD;
        this.tenQD = tenQD;
        this.giaTri = giaTri;
    }

    public Long getMaQD() {
        return maQD;
    }

    public void setMaQD(Long maQD) {
        this.maQD = maQD;
    }

    public String getTenQD() {
        return tenQD;
    }

    public void setTenQD(String tenQD) {
        this.tenQD = tenQD;
    }

    public String getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(String giaTri) {
        this.giaTri = giaTri;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maQD != null ? maQD.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuiDinh)) {
            return false;
        }
        QuiDinh other = (QuiDinh) object;
        if ((this.maQD == null && other.maQD != null) || (this.maQD != null && !this.maQD.equals(other.maQD))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.springmvc.pojo.QuiDinh[ maQD=" + maQD + " ]";
    }

}
