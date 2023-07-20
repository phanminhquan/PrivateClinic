package com.springmvc.service;

import com.springmvc.dto.BacSiDTO;

import java.util.List;

public interface BacSiService {
    List<BacSiDTO> getListBS();

    BacSiDTO createBS (BacSiDTO bacSiDTO);

    void deleteBS(Long id);

    BacSiDTO updateBS (BacSiDTO bacSiDTO);

    BacSiDTO findBSByID (Long id);
}
