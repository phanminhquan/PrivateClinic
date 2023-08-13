/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springmvc.pojo;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author user
 */
@Entity
@Table(name = "date_of_week")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DateOfWeek.findAll", query = "SELECT d FROM DateOfWeek d"),
    @NamedQuery(name = "DateOfWeek.findById", query = "SELECT d FROM DateOfWeek d WHERE d.id = :id"),
    @NamedQuery(name = "DateOfWeek.findByDateOfWeek", query = "SELECT d FROM DateOfWeek d WHERE d.dateOfWeek = :dateOfWeek")})
public class DateOfWeek implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "date_of_week")
    private String dateOfWeek;
    @OneToMany(mappedBy = "idNgay")
    private Set<CaTrucTrongTuan> caTrucTrongTuanSet;

    public DateOfWeek() {
    }

    public DateOfWeek(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDateOfWeek() {
        return dateOfWeek;
    }

    public void setDateOfWeek(String dateOfWeek) {
        this.dateOfWeek = dateOfWeek;
    }

    @XmlTransient
    public Set<CaTrucTrongTuan> getCaTrucTrongTuanSet() {
        return caTrucTrongTuanSet;
    }

    public void setCaTrucTrongTuanSet(Set<CaTrucTrongTuan> caTrucTrongTuanSet) {
        this.caTrucTrongTuanSet = caTrucTrongTuanSet;
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
        if (!(object instanceof DateOfWeek)) {
            return false;
        }
        DateOfWeek other = (DateOfWeek) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.springmvc.pojo.DateOfWeek[ id=" + id + " ]";
    }
    
}
