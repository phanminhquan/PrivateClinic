package com.springmvc.dto;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class NhanVienDTO {
    private Long maNv;
    @NotEmpty(message = "{nhanvien.hoten.notNullMsg}")
    @Size(min = 1, max = 50, message = "{nhanvien.hoten.size}")
    @NotBlank(message = "{formspace}")
    private String hoTen;
    @NotEmpty(message = "{nhanvien.email.notNullMsg}")
    @Size(min = 1, max = 50, message = "{nhanvien.email.size}")
    @NotBlank(message = "{formspace}")
    private String email;
    @NotEmpty(message = "{nhanvien.ngaysinh.notNullMsg}")
    @Column(name = "ngaySinh")
    private String ngaySinh;
    @NotEmpty(message = "{nhanvien.diachi.notNullMsg}")
    @Size(min = 1, max = 100, message = "{nhanvien.diachi.size}")
    @NotBlank(message = "{formspace}")
    private String diaChi;
    @NotEmpty(message = "{nhanvien.dienthoai.notNullMsg}")
    @Size(min = 10, max = 10, message = "{nhanvien.dienthoai.size}")
    @NotBlank(message = "{formspace}")
    private String dienThoai;
    private String hinhAnh;
    private Long idUser;
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public Long getMaNv() {
        return this.maNv;
    }

    public void setMaNv(Long maNv) {
        this.maNv = maNv;
    }

    public String getHoTen() {
        return this.hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNgaySinh() {
        return this.ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return this.diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getDienThoai() {
        return this.dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getHinhAnh() {
        return this.hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public Long getIdUser() {
        return this.idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
}
