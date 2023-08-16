package com.springmvc.service;

import com.springmvc.dto.BenhNhanDTO;
import com.springmvc.pojo.BenhNhan;

import java.util.List;
import java.util.Map;

public interface BenhNhanService {
    List<BenhNhanDTO> SearchBN (String kw);

    List<BenhNhanDTO> getALL (Map<String,String> params);

    BenhNhanDTO getBNById (long id);
}
