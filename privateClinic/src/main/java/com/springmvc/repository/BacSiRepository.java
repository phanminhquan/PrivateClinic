package com.springmvc.repository;

import com.springmvc.dto.BacSiDTO;
import com.springmvc.pojo.BacSi;
import com.springmvc.pojo.NhanVien;

import java.util.List;

public interface BacSiRepository {
    List<BacSi> getListBS();

    NhanVien findUserById (Long id);

    BacSi createBS (BacSi bacSi);

    void deleteBS (Long id);

    BacSi findBacSiById (Long id);

    BacSi updateBS (BacSi bacSi);
}
