package com.springmvc.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "thoi_gian")
public class ThoiGian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maTG")
    private Long maTg;

    @Column(name = "gio")
    private LocalDateTime gio;

}
