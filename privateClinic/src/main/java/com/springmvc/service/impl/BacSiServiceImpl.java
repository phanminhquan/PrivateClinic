package com.springmvc.service.impl;

import com.springmvc.dto.BacSiDTO;
import com.springmvc.pojo.BacSi;
import com.springmvc.pojo.NhanVien;
import com.springmvc.pojo.Thuoc;
import com.springmvc.repository.BacSiRepository;
import com.springmvc.service.BacSiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BacSiServiceImpl implements BacSiService {

    @Autowired
    private BacSiRepository bacSiRepository;

    public BacSiDTO toDto (BacSi bacSi)
    {
        BacSiDTO bs = new BacSiDTO();
        bs.setMaBs(bacSi.getMaBS());
        bs.setChungChi(bacSi.getChungChi());
        bs.setChuyenMon(bacSi.getChuyenMon());
        bs.setMaNv(bacSi.getMaNV().getMaNV());
        return bs;
    }
    public List<BacSiDTO> toBacSiDTO(List<BacSi> t) {
        List<BacSiDTO> bacSiDTOS = new ArrayList<>();
        for(BacSi bacSi: t)
        {
            BacSiDTO dto = toDto(bacSi);
            bacSiDTOS.add(dto);
        }
        return bacSiDTOS;
    }

    @Override
    public List<BacSiDTO> getListBS() {
        List<BacSi> bs = bacSiRepository.getListBS();
        return toBacSiDTO(bs);
    }
}
