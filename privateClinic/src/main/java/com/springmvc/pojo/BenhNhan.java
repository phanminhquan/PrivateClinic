package com.springmvc.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "benh_nhan")
public class BenhNhan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maBN")
    private Long maBn;

    @Column(name = "hoTen")
    private String hoTen;

    @Column(name = "dienThoai")
    private String dienThoai;

    @Column(name = "email")
    private String email;

    @Column(name = "ngaySinh")
    private Date ngaySinh;

    @Column(name = "gioiTinh")
    private Boolean gioiTinh;

    @Column(name = "diaChi")
    private String diaChi;

    @Column(name = "avatar")
    private String avatar;
}
