package com.springmvc.service;

import com.springmvc.dto.BenhNhanDTO;
import com.springmvc.dto.PhieuKhamDTO;
import java.rmi.MarshalledObject;
import java.util.Map;
import java.text.ParseException;
import java.util.List;

public interface PhieuKhamService {

    PhieuKhamDTO createPhieuKham(PhieuKhamDTO phieuKhamDTO);

    List<PhieuKhamDTO> getlistPK();

    BenhNhanDTO getBenhNhanByID(Long id);

    PhieuKhamDTO addOrUpdatePhieu(PhieuKhamDTO phieuKhamDTO) throws ParseException;

    PhieuKhamDTO getPhieuKhamByID(long id);

    List<PhieuKhamDTO> getAllPhieuKham();

    List<PhieuKhamDTO> findPkByName(String kw);
    List<Object[]> getListObjUI(Map<String,String> map);

}
