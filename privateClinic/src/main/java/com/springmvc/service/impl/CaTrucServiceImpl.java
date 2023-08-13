package com.springmvc.service.impl;

import com.springmvc.dto.CaTrucDTO;
import com.springmvc.pojo.CaTruc;
import com.springmvc.repository.CaTrucRepository;
import com.springmvc.service.CaTrucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class CaTrucServiceImpl implements CaTrucService {
    @Autowired
    private CaTrucRepository caTrucRepository;
    private CaTrucDTO toDTO(CaTruc entity){
        CaTrucDTO caTrucDTO = new CaTrucDTO();
        if(entity.getMaCT() !=null){
            caTrucDTO.setMaCt(entity.getMaCT());
        }
        caTrucDTO.setGioTruc(entity.getGioTruc().toString());
        caTrucDTO.setGioKetThuc(entity.getGioKetThuc().toString());
        return caTrucDTO;
    }
    private CaTruc toEntity(CaTrucDTO dto) throws ParseException {
        CaTruc caTruc = new CaTruc();
        if(dto.getMaCt() !=null){
            caTruc.setMaCT(dto.getMaCt());
        }
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");

        java.util.Date d1 =(java.util.Date)format.parse(dto.getGioTruc());
        java.sql.Time gioTruc = new java.sql.Time(d1.getTime());

        java.util.Date d2 =(java.util.Date)format.parse(dto.getGioKetThuc());
        java.sql.Time gioKetThuc = new java.sql.Time(d2.getTime());

        caTruc.setGioTruc(gioTruc);
        caTruc.setGioKetThuc(gioKetThuc);
        return caTruc;
    }
    List<CaTrucDTO> toListDTO(List<CaTruc> list){
        List<CaTrucDTO> dtoList = new ArrayList<>();
        for (CaTruc c : list)
            dtoList.add(toDTO(c));
        return dtoList;
    }
    @Override
    public List<CaTrucDTO> getListCaTrucByDate(int date) {
        return toListDTO(caTrucRepository.getListCaTrucByDate(date));
    }

    @Override
    public List<CaTrucDTO> getListCaTruc() {
        return toListDTO(caTrucRepository.getListCaTruc());
    }

    @Override
    public String addNhanVienToCaTruc(long idNhanVien, int idCT) {
        return caTrucRepository.addStaffToShift(idNhanVien,idCT);
    }

    @Override
    public void delNhanVienCaTruc(int id) {
        caTrucRepository.delNhanVienCaTruc(id);
    }

    @Override
    public CaTrucDTO addOrUpdateCaTruc(CaTrucDTO caTruc) throws ParseException {
        CaTruc ct = toEntity(caTruc);
        ct = caTrucRepository.addOrUpDateCaTruc(ct);
        if (ct == null)
            return null;
        return toDTO(ct);
    }

    @Override
    public void delCaTrucTrongTuan(int idCaTruc, int idNgay) {
        caTrucRepository.delCaTrucTrongTuan(idCaTruc,idNgay);
    }

    @Override
    public List<Integer> addCaTrucVaoNgay(List<Integer> listId, int idNgay) {
        return caTrucRepository.addCaTrucVaoNgay(listId,idNgay);
    }

    @Override
    public void delCaTruc(int id) {
        this.caTrucRepository.delCaTruc(id);
    }

    @Override
    public CaTrucDTO getCaTrucById(int id) {
        return toDTO(caTrucRepository.getCaTrucById(id));
    }
}
