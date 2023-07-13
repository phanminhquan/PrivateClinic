package com.springmvc.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "phieu_thuoc")
public class PhieuThuoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maPK_Thuoc")
    private Long maPkThuoc;

    @Column(name = "soLuong")
    private Integer soLuong;

    @Column(name = "cachDung")
    private String cachDung;

    @Column(name = "maThuoc")
    private Long maThuoc;

    @Column(name = "maPK")
    private Long maPk;

}
