package com.springmvc.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "thuoc")
public class Thuoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maThuoc")
    private Long maThuoc;

    @Column(name = "tenThuoc")
    private String tenThuoc;

    @Column(name = "moTa")
    private String moTa;

    @Column(name = "soLuong")
    private Integer soLuong;

    @Column(name = "giaBan")
    private Float giaBan;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "donVi")
    private String donVi;

    @Column(name = "hinhAnh")
    private String hinhAnh;

}
