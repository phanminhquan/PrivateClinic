package com.springmvc.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "ct_ds_kham")
public class CtDsKham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maCTDS")
    private Long maCtds;

    @Column(name = "maBN")
    private Long maBn;

    @Column(name = "maDS")
    private Long maDs;

    @Column(name = "maTG")
    private Long maTg;

    @Column(name = "trangthai")
    private Boolean trangthai;

}
