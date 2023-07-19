package com.springmvc.service.impl;

import com.springmvc.dto.BacSiDTO;
import com.springmvc.pojo.BacSi;
import com.springmvc.repository.BacSiRepository;
import com.springmvc.service.BacSiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BacSiServiceImpl implements BacSiService {

    @Autowired
    private BacSiRepository bacSiRepository;

    public BacSiDTO toDto (BacSi bacSi)
    {
        BacSiDTO bs = new BacSiDTO();
        bs.setMaBs(bacSi.getMaBS());
        return bs;
    }
    @Override
    public List<BacSiDTO> getListBS() {

        return null;
    }
}
