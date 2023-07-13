package com.springmvc.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "bac_si")
public class BacSi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maBS")
    private Long maBs;

    @Column(name = "chungChi")
    private String chungChi;

    @Column(name = "chuyenMon")
    private String chuyenMon;

}
