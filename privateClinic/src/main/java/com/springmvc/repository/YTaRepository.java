package com.springmvc.repository;

import com.springmvc.dto.YtaDTO;
import com.springmvc.pojo.BacSi;
import com.springmvc.pojo.NhanVien;
import com.springmvc.pojo.Yta;

import java.util.List;

public interface YTaRepository {
    List<Yta> listYta();
    Yta getYTaByID(long id);
    void deleteYTa(long id);
    Yta updateYTa(Yta yta);
    Yta createYta(Yta yta);
    NhanVien findUserById (Long id);

}
