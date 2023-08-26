package com.springmvc.service.impl;

import com.springmvc.dto.CtDsKhamDTO;
import com.springmvc.pojo.CtDsKham;
import com.springmvc.repository.BenhNhanRepository;
import com.springmvc.repository.CtDsKhamRepository;
import com.springmvc.repository.DsKhamBenhRepository;
import com.springmvc.repository.ThoiGianRepsitory;
import com.springmvc.service.CtDsKhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class CtDsKhamServiceImpl implements CtDsKhamService {
    @Autowired
    private CtDsKhamRepository ctDsKhamRepository;

    @Autowired
    private ThoiGianRepsitory thoiGianRepsitory;
    @Autowired
    private BenhNhanRepository benhNhanRepository;
    @Autowired
    private DsKhamBenhRepository dsKhamBenhRepository;


    private CtDsKhamDTO toDTO(CtDsKham ctDsKham) {
        CtDsKhamDTO dto = new CtDsKhamDTO();
        if (ctDsKham.getMaCTDS() != null) {
            dto.setMaCtds(ctDsKham.getMaCTDS());
        }
        dto.setMaBn(ctDsKham.getMaBN().getMaBN());
        dto.setTrangthai(ctDsKham.getTrangthai());
        dto.setMaTg(ctDsKham.getMaTG().getMaTG());
        dto.setNgayKham(ctDsKham.getNgaykham());
        return dto;
    }

    private CtDsKham toEntity(CtDsKhamDTO ctDsKhamDTO) {
        CtDsKham ct = new CtDsKham();
        if (ctDsKhamDTO.getMaCtds() != null) {
            ct.setMaCTDS(ctDsKhamDTO.getMaCtds());
        }
        ct.setNgaykham(ctDsKhamDTO.getNgayKham());
        ct.setTrangthai(ctDsKhamDTO.getTrangthai());
        ct.setMaBN(benhNhanRepository.getBenhNhanByID(ctDsKhamDTO.getMaBn()));
        ct.setMaTG(thoiGianRepsitory.getThoiGianByID(ctDsKhamDTO.getMaTg()));
        return ct;
    }

    List<CtDsKhamDTO> toListDto(List<CtDsKham> list) {
        List<CtDsKhamDTO> l = new ArrayList<>();
        for (CtDsKham ct : list)
            l.add(toDTO(ct));
        return l;
    }


    @Override
    public Map<String, String> AcceptOrdennyDanhSachKham(long id, Integer status) {
        return ctDsKhamRepository.AcceptOrdennyDanhSachKham(id, status);
    }

    @Override
    public List<Object[]> getListCtDSKham(Map<String, String> params) {
        return ctDsKhamRepository.getListCtDSKham(params);
    }

    @Override
    public CtDsKhamDTO addLichKham(CtDsKhamDTO ctDsKhamDTO) {
        CtDsKham ctDsKham = new CtDsKham();
        ctDsKham = toEntity(ctDsKhamDTO);
        ctDsKham = ctDsKhamRepository.addLichKham(ctDsKham);
        return toDTO(ctDsKham);
    }

    @Override
    public void DeleteLichKham(Long id) {
        ctDsKhamRepository.DeleteLichKham(id);
    }

    @Override
    public List<Object[]> getListHistoryByUser(Long id,Map<String,String> params) {
        return ctDsKhamRepository.getListHistoryByUser(id,params);
    }

    @Override
    public void huyLichHen(Long id) {
        ctDsKhamRepository.huyLichHen(id);
    }

//    @Override
//    public CtDsKhamDTO create(CtDsKhamDTO ctDsKhamDTO) {
//        CtDsKham ct = toEntity(ctDsKhamDTO);
//
//        ThoiGian thoiGian = thoiGianRepsitory.getThoiGianByID(ctDsKhamDTO.getMaTg());
//        ct.setMaTG(thoiGian);
//
//        BenhNhan benhNhan = benhNhanRepository.getBenhNhanByID(ctDsKhamDTO.getMaBn());
//        ct.setMaBN(benhNhan);
//        DsKhamBenh ds = dsKhamBenhRepository.getByID(ctDsKhamDTO.getMaDs());
//        ct.setMaDS(ds);
//
//        ct = ctDsKhamRepository.create(ct);
//
//        return toDTO(ct);
//    }
//
//    @Override
//    public void delete(long id) {
//        ctDsKhamRepository.delete(id);
//    }
//
//    @Override
//    public CtDsKhamDTO update(CtDsKhamDTO ctDsKhamDTO) {
//        CtDsKham ct = toEntity(ctDsKhamDTO);
//
//        ThoiGian thoiGian = thoiGianRepsitory.getThoiGianByID(ctDsKhamDTO.getMaTg());
//        ct.setMaTG(thoiGian);
//
//        BenhNhan benhNhan = benhNhanRepository.getBenhNhanByID(ctDsKhamDTO.getMaBn());
//        ct.setMaBN(benhNhan);
//        DsKhamBenh ds = dsKhamBenhRepository.getByID(ctDsKhamDTO.getMaDs());
//        ct.setMaDS(ds);
//
//        ct = ctDsKhamRepository.update(ct);
//
//        return toDTO(ct);
//    }
//
//    @Override
//    public void AcceptDanhSachKham(long id) {
//        ctDsKhamRepository.AcceptDanhSachKham(id);
//    }
//
//    @Override
//    public List<CtDsKhamDTO> getListCtDSKham() {
//        List<CtDsKhamDTO> list = new ArrayList<>();
//        for(CtDsKham c : ctDsKhamRepository.getListCtDSKham()){
//            list.add(toDTO(c));
//        }
//        return list;
//    }
//
//    @Override
//    public CtDsKhamDTO getByID(long id) {
//        return toDTO(ctDsKhamRepository.getByID(id));
//    }
}
