package com.springmvc.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "ds_kham_benh")
public class DsKhamBenh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maDS")
    private Long maDs;

    @Column(name = "ngayKham")
    private Date ngayKham;

}
