package com.springmvc.service.impl;

import com.springmvc.dto.BacSiDTO;
import com.springmvc.dto.YtaDTO;
import com.springmvc.pojo.BacSi;
import com.springmvc.pojo.NhanVien;
import com.springmvc.pojo.Yta;
import com.springmvc.repository.YTaRepository;
import com.springmvc.service.YTaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class YTaServiceImpl implements YTaService {

    @Autowired
    YTaRepository yTaRepository;


    public YtaDTO toDto (Yta yta)
    {
        YtaDTO y = new YtaDTO();
        if(yta.getMaYT() != null) {
            y.setMaYt(yta.getMaYT());
        }
        y.setMaNv(yta.getMaNV().getMaNV());
        y.setBangCap(yta.getBangCap());
        return y;
    }

    public Yta toEntity (YtaDTO ytaDTO)
    {
        Yta yta = new Yta();
        yta.setMaYT(ytaDTO.getMaYt());
        yta.setBangCap(ytaDTO.getBangCap());
        return yta;
    }
    @Override
    public List<YtaDTO> listYta() {
        List<YtaDTO> ytaDTOS = new ArrayList<>();
        for(Yta y : yTaRepository.listYta()){
            ytaDTOS.add(toDto(y));
        }
        return  ytaDTOS;
    }

    @Override
    public YtaDTO getYTaByID(long id) {
        return toDto(yTaRepository.getYTaByID(id));
    }

    @Override
    public void deleteYTa(long id) {
        yTaRepository.deleteYTa(id);
    }

    @Override
    public YtaDTO updateYTa(YtaDTO yta) {
        Yta yt = toEntity(yta);
        NhanVien nhanVien = yTaRepository.findUserById(yta.getMaNv());
        yt.setMaNV(nhanVien);
        yt = yTaRepository.updateYTa(yt);
        return toDto(yt);
    }

    @Override
    public YtaDTO createYta(YtaDTO yta) {
        Yta y = new Yta();
        y = toEntity(yta);
        NhanVien nhanVien = yTaRepository.findUserById(yta.getMaNv());
        y.setMaNV(nhanVien);
        y= yTaRepository.createYta(y);
        return toDto(y);
    }
}
