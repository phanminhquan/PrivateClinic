package com.springmvc.service;

import com.springmvc.customresponse.BacSiResponse;
import com.springmvc.dto.BacSiDTO;

import java.util.List;
import java.util.Map;

public interface BacSiService {
    List<BacSiDTO> getListBS();

    BacSiDTO createBS (BacSiDTO bacSiDTO);

    void deleteBS(Long id);

    BacSiDTO updateBS (BacSiDTO bacSiDTO);

    BacSiDTO findBSByID (Long id);

    List<Object[]> getList(Map<String, String> params);

    List<String> getAllChuyenMon();
}
