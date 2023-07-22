package com.springmvc.service;

import com.springmvc.dto.YtaDTO;
import com.springmvc.pojo.Yta;

import java.util.List;

public interface YTaService {
    List<YtaDTO> listYta();
    YtaDTO getYTaByID(long id);
    void deleteYTa(long id);
    YtaDTO updateYTa(YtaDTO yta);
    YtaDTO createYta(YtaDTO yta);
}
