package com.springmvc.service;

import com.springmvc.dto.CtDsKhamDTO;

import java.util.List;
import java.util.Map;

public interface CtDsKhamService {
    //    CtDsKhamDTO create(CtDsKhamDTO ctDsKham);
//    void delete(long id);
//    CtDsKhamDTO update(CtDsKhamDTO ctDsKham);
    Map<String, String> AcceptOrdennyDanhSachKham(long id, Integer status);

    List<Object[]> getListCtDSKham(Map<String, String> params);

    //    CtDsKhamDTO getByID(long id);
    CtDsKhamDTO addLichKham(CtDsKhamDTO ctDsKhamDTO);

    void DeleteLichKham(Long id);
    List<Object[]> getListHistoryByUser(Long id,Map<String,String> params);
    void huyLichHen(Long id);
}
