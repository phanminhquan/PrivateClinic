package com.springmvc.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "nhanvien_catruc")
public class NhanvienCatruc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maNV_CT")
    private Integer maNvCt;

    @Column(name = "id_CT")
    private Integer idCt;

    @Column(name = "id_NV")
    private Long idNv;

}
