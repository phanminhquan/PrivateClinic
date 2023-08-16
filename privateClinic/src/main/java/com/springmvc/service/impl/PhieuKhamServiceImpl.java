package com.springmvc.service.impl;

import com.springmvc.dto.BenhNhanDTO;
import com.springmvc.dto.PhieuKhamDTO;
import com.springmvc.pojo.BenhNhan;
import com.springmvc.pojo.NhanVien;
import com.springmvc.pojo.PhieuKham;
import com.springmvc.repository.BenhNhanRepository;
import com.springmvc.repository.PhieuKhamRepository;
import com.springmvc.service.PhieuKhamService;
import com.springmvc.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PhieuKhamServiceImpl implements PhieuKhamService {
    @Autowired
    private PhieuKhamRepository phieuKhamRepository;

    @Autowired
    private BenhNhanRepository benhNhanRepository;

    public PhieuKhamDTO toDTO(PhieuKham phieuKham) {
        PhieuKhamDTO p = new PhieuKhamDTO();
        p.setMaPk(phieuKham.getMaPK());

        p.setNgayKham(phieuKham.getNgayKham().toString());
        p.setTrieuChung(phieuKham.getTrieuChung());
        p.setChuanDoan(phieuKham.getChuanDoan());
        p.setMaBn(phieuKham.getMaBN().getMaBN());
        p.setXacnhan(phieuKham.getXacnhan());
        p.setMaBS(phieuKham.getMaBS().getMaNV());
        return p;
    }

    public List<PhieuKhamDTO> tolistDTO(List<PhieuKham> phieuKhams) {
        List<PhieuKhamDTO> phieuKhamDTOS = new ArrayList<>();
        for (PhieuKham phieuKham : phieuKhams) {
            PhieuKhamDTO dto = toDTO(phieuKham);
            phieuKhamDTOS.add(dto);
        }
        return phieuKhamDTOS;
    }

    public PhieuKham toEntity(PhieuKhamDTO phieuKham) throws ParseException {
        PhieuKham p = new PhieuKham();
        p.setMaPK(phieuKham.getMaPk());

        String year = phieuKham.getNgayKham().substring(0, 4);
        String month = phieuKham.getNgayKham().substring(5, 7);
        String date = phieuKham.getNgayKham().substring(8, 10);
        String createDate = date.concat("/").concat(month).concat("/").concat(year);
        Date d = Utils.dateParse(createDate);

        p.setNgayKham(d);
        p.setTrieuChung(phieuKham.getTrieuChung());
        p.setChuanDoan(phieuKham.getChuanDoan());
        p.setXacnhan(phieuKham.getXacnhan());
        return p;
    }

    @Override
    public PhieuKhamDTO createPhieuKham(PhieuKhamDTO phieuKhamDTO) {
        PhieuKham p = new PhieuKham();
        return null;
    }

    @Override
    public List<PhieuKhamDTO> getlistPK() {
        List<PhieuKham> phieuKham = phieuKhamRepository.getlistPK();
        return tolistDTO(phieuKham);
    }

    @Override
    public BenhNhanDTO getBenhNhanByID(Long id) {
        BenhNhan benhNhan = benhNhanRepository.getBenhNhanByID(id);
        PhieuKhamDTO phieuKhamDTO = new PhieuKhamDTO();
        phieuKhamDTO.setMaBn(id);
        return null;
    }

    @Override
    public PhieuKhamDTO addOrUpdatePhieu(PhieuKhamDTO phieuKhamDTO) throws ParseException {
        PhieuKham phieuKham = new PhieuKham();
        phieuKham = toEntity(phieuKhamDTO);
        BenhNhan benhNhan = benhNhanRepository.getBenhNhanByID(phieuKhamDTO.getMaBn());
        phieuKham.setMaBN(benhNhan);
        NhanVien nhanVien = phieuKhamRepository.getNhanVienById(phieuKhamDTO.getMaBS());
        phieuKham.setMaBS(nhanVien);
        phieuKham = phieuKhamRepository.addOrUpdatePhieu(phieuKham);
        return toDTO(phieuKham);
    }

    @Override
    public PhieuKhamDTO getPhieuKhamByID(long id) {
        return toDTO(phieuKhamRepository.getPhieuKhamByID(id));
    }

    @Override
    public List<PhieuKhamDTO> getAllPhieuKham() {
        List<PhieuKham> list = phieuKhamRepository.getAllPhieuKham();
        return tolistDTO(list);
    }

    @Override
    public List<PhieuKhamDTO> findPkByName(String kw) {
        List<PhieuKham> list = phieuKhamRepository.findPkByName(kw);
        return tolistDTO(list);
    }
}
