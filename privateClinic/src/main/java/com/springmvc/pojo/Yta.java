package com.springmvc.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "yta")
public class Yta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maYT")
    private Long maYt;

    @Column(name = "bangCap")
    private String bangCap;

}
