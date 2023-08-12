/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springmvc.pojo;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "nhan_vien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NhanVien.findAll", query = "SELECT n FROM NhanVien n"),
    @NamedQuery(name = "NhanVien.findByMaNV", query = "SELECT n FROM NhanVien n WHERE n.maNV = :maNV"),
    @NamedQuery(name = "NhanVien.findByHoTen", query = "SELECT n FROM NhanVien n WHERE n.hoTen = :hoTen"),
    @NamedQuery(name = "NhanVien.findByEmail", query = "SELECT n FROM NhanVien n WHERE n.email = :email"),
    @NamedQuery(name = "NhanVien.findByNgaySinh", query = "SELECT n FROM NhanVien n WHERE n.ngaySinh = :ngaySinh"),
    @NamedQuery(name = "NhanVien.findByDiaChi", query = "SELECT n FROM NhanVien n WHERE n.diaChi = :diaChi"),
    @NamedQuery(name = "NhanVien.findByDienThoai", query = "SELECT n FROM NhanVien n WHERE n.dienThoai = :dienThoai"),
    @NamedQuery(name = "NhanVien.findByHinhAnh", query = "SELECT n FROM NhanVien n WHERE n.hinhAnh = :hinhAnh")})
public class NhanVien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "maNV")
    private Long maNV;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "hoTen")
    private String hoTen;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ngaySinh")
    @Temporal(TemporalType.TIMESTAMP)
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngaySinh;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "diaChi")
    private String diaChi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "dienThoai")
    private String dienThoai;
    @Size(max = 200)
    @Column(name = "hinhAnh")
    private String hinhAnh;
    @OneToOne( mappedBy = "maNV")
    private TaiKhoan taiKhoan;
    @JoinColumn(name = "IdUser", referencedColumnName = "Id")
    @ManyToOne
    private UserRole idUser;
    @OneToMany(mappedBy = "idNV")
    private Set<NhanvienCatruc> nhanvienCatrucSet;

    @Transient
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public NhanVien() {
    }

    public NhanVien(Long maNV) {
        this.maNV = maNV;
    }

    public NhanVien(Long maNV, String hoTen, String email, Date ngaySinh, String diaChi, String dienThoai) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.email = email;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.dienThoai = dienThoai;
    }

    public Long getMaNV() {
        return maNV;
    }

    public void setMaNV(Long maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public UserRole getIdUser() {
        return idUser;
    }

    public void setIdUser(UserRole idUser) {
        this.idUser = idUser;
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
        hash += (maNV != null ? maNV.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NhanVien)) {
            return false;
        }
        NhanVien other = (NhanVien) object;
        if ((this.maNV == null && other.maNV != null) || (this.maNV != null && !this.maNV.equals(other.maNV))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.springmvc.pojo.NhanVien[ maNV=" + maNV + " ]";
    }
    
}
