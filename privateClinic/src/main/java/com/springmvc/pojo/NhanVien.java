package com.springmvc.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "nhan_vien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maNV")
    private Long maNv;

    @Column(name = "hoTen")
    private String hoTen;

    @Column(name = "email")
    private String email;

    @Column(name = "ngaySinh")
    private Date ngaySinh;

    @Column(name = "diaChi")
    private String diaChi;

    @Column(name = "dienThoai")
    private String dienThoai;

    @Column(name = "hinhAnh")
    private String hinhAnh;

}
