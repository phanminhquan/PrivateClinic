package com.springmvc.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "hoa_don")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maHD")
    private Long maHd;

    @Column(name = "tienThuoc")
    private Float tienThuoc;

    @Column(name = "tienKham")
    private Float tienKham;

    @Column(name = "tongTien")
    private Float tongTien;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "maPK")
    private Long maPk;

}
