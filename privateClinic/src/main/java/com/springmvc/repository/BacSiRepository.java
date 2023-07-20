package com.springmvc.repository;

import com.springmvc.dto.BacSiDTO;
import com.springmvc.pojo.BacSi;

import java.util.List;

public interface BacSiRepository {
    List<BacSi> getListBS();

    Long findUserById ();
}
