package com.springmvc.service;

import com.springmvc.dto.CaTrucDTO;
import com.springmvc.dto.CaTrucTrongTuanDTO;
import com.springmvc.pojo.CaTruc;
import com.springmvc.pojo.CaTrucTrongTuan;


import java.text.ParseException;
import java.util.List;

public interface CaTrucService {
    List<CaTrucDTO> getListCaTrucByDate(int date);
    List<CaTrucDTO> getListCaTruc();
    String addNhanVienToCaTruc(long idNhanVien, int idCT);
    void delNhanVienCaTruc(int id);
    CaTrucDTO addOrUpdateCaTruc(CaTrucDTO caTruc) throws ParseException;
    void delCaTrucTrongTuan(int idCaTruc,int idNgay);
    public List<Integer> addCaTrucVaoNgay(List<Integer> listId, int idNgay);
    void delCaTruc(int id);
    CaTrucDTO getCaTrucById(int id);
    List<CaTrucDTO> getListCaTrucByDayAnhNhanVien(int iddae, long idnv);
    CaTrucTrongTuanDTO getCaTrucTrongTuanByDayAndCaTruc(int iddate, int idct);
}
