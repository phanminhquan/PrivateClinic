package com.springmvc.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "qui_dinh")
public class QuiDinh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maQD")
    private Long maQd;

    @Column(name = "tenQD")
    private String tenQd;

    @Column(name = "giaTri")
    private String giaTri;
}
