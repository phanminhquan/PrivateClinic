package com.springmvc.service.impl;

import com.springmvc.dto.CtDsKhamDTO;
import com.springmvc.pojo.BenhNhan;
import com.springmvc.pojo.CtDsKham;

import com.springmvc.pojo.DsKhamBenh;
import com.springmvc.pojo.ThoiGian;
import com.springmvc.repository.BenhNhanRepository;
import com.springmvc.repository.CtDsKhamRepository;
import com.springmvc.repository.DsKhamBenhRepository;
import com.springmvc.repository.ThoiGianRepsitory;
import com.springmvc.service.CtDsKhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


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


    private CtDsKhamDTO toDTO(CtDsKham ctDsKham){
        CtDsKhamDTO dto = new CtDsKhamDTO();
        if(ctDsKham.getMaCTDS() !=null){
            dto.setMaCtds(ctDsKham.getMaCTDS());
        }
        dto.setMaBn(ctDsKham.getMaBN().getMaBN());
        dto.setMaDs(ctDsKham.getMaDS().getMaDS());
        dto.setTrangthai(ctDsKham.getTrangthai());
        dto.setMaTg(ctDsKham.getMaTG().getMaTG());
        return dto;
    }

    private CtDsKham toEntity(CtDsKhamDTO ctDsKhamDTO){
        CtDsKham ct = new CtDsKham();
        ct.setTrangthai(ct.getTrangthai());
        ct.setMaCTDS(ctDsKhamDTO.getMaCtds());
        return ct;
    }

    @Override
    public CtDsKhamDTO create(CtDsKhamDTO ctDsKhamDTO) {
        CtDsKham ct = toEntity(ctDsKhamDTO);

        ThoiGian thoiGian = thoiGianRepsitory.getThoiGianByID(ctDsKhamDTO.getMaTg());
        ct.setMaTG(thoiGian);

        BenhNhan benhNhan = benhNhanRepository.getBenhNhanByID(ctDsKhamDTO.getMaBn());
        ct.setMaBN(benhNhan);
        DsKhamBenh ds = dsKhamBenhRepository.getByID(ctDsKhamDTO.getMaDs());
        ct.setMaDS(ds);

        ct = ctDsKhamRepository.create(ct);

        return toDTO(ct);
    }

    @Override
    public void delete(long id) {
        ctDsKhamRepository.delete(id);
    }

    @Override
    public CtDsKhamDTO update(CtDsKhamDTO ctDsKhamDTO) {
        CtDsKham ct = toEntity(ctDsKhamDTO);

        ThoiGian thoiGian = thoiGianRepsitory.getThoiGianByID(ctDsKhamDTO.getMaTg());
        ct.setMaTG(thoiGian);

        BenhNhan benhNhan = benhNhanRepository.getBenhNhanByID(ctDsKhamDTO.getMaBn());
        ct.setMaBN(benhNhan);
        DsKhamBenh ds = dsKhamBenhRepository.getByID(ctDsKhamDTO.getMaDs());
        ct.setMaDS(ds);

        ct = ctDsKhamRepository.update(ct);

        return toDTO(ct);
    }

    @Override
    public void AcceptDanhSachKham(long id) {
        ctDsKhamRepository.AcceptDanhSachKham(id);
    }

    @Override
    public List<CtDsKhamDTO> getListCtDSKham() {
        List<CtDsKhamDTO> list = new ArrayList<>();
        for(CtDsKham c : ctDsKhamRepository.getListCtDSKham()){
            list.add(toDTO(c));
        }
        return list;
    }

    @Override
    public CtDsKhamDTO getByID(long id) {
        return toDTO(ctDsKhamRepository.getByID(id));
    }
}
