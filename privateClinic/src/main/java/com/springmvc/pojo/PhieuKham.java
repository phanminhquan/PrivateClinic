package com.springmvc.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "phieu_kham")
public class PhieuKham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maPK")
    private Long maPk;

    @Column(name = "ngayKham")
    private Date ngayKham;

    @Column(name = "trieuChung")
    private String trieuChung;

    @Column(name = "chuanDoan")
    private String chuanDoan;

    @Column(name = "maBN")
    private Long maBn;

    @Column(name = "xacnhan")
    private Boolean xacnhan;

}
