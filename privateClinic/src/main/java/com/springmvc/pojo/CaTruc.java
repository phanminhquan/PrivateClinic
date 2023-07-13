package com.springmvc.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "ca_truc")
public class CaTruc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maCT")
    private Integer maCt;

    @Column(name = "gioTruc")
    private LocalDateTime gioTruc;

}
