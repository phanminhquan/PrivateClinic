package com.springmvc.repository;

import com.springmvc.customresponse.BacSiResponse;
import com.springmvc.dto.BacSiDTO;
import com.springmvc.pojo.BacSi;
import com.springmvc.pojo.NhanVien;

import java.util.List;
import java.util.Map;

public interface BacSiRepository {
    List<BacSi> getListBS();

    NhanVien findUserById (Long id);

    BacSi createBS (BacSi bacSi);

    void deleteBS (Long id);

    BacSi findBacSiById (Long id);

    BacSi updateBS (BacSi bacSi);

    List<Object[]> getListBacSi(Map<String, String> params);
}
