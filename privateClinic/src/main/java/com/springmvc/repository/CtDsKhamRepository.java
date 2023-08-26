package com.springmvc.repository;

import com.springmvc.pojo.CtDsKham;

import java.util.List;
import java.util.Map;

public interface CtDsKhamRepository {
    //    CtDsKham create(CtDsKham ctDsKham);
//    void delete(long id);
//    CtDsKham update(CtDsKham ctDsKham);
    Map<String, String> AcceptOrdennyDanhSachKham(long id, Integer status);

    List<Object[]> getListCtDSKham(Map<String, String> params);

    //    CtDsKham getByID(long id);
    CtDsKham addLichKham(CtDsKham ctDsKham);

    void DeleteLichKham(Long id);
    List<Object[]> getListHistoryByUser(Long idtk,Map<String,String> params);
    void huyLichHen(Long id);

}
