package com.springmvc.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.springmvc.dto.TaiKhoanDTO;
import com.springmvc.dto.Util;
import com.springmvc.pojo.NhanVien;
import com.springmvc.pojo.TaiKhoan;
import com.springmvc.repository.TaiKhoanRepository;
import com.springmvc.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service("userDetailsService")
public class TaiKhoanServiceImpl implements TaiKhoanService {
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private Cloudinary cloudinary;

    public TaiKhoanDTO toDto(TaiKhoan taiKhoan){
        TaiKhoanDTO t = new TaiKhoanDTO();
        t.setId(null);
        t.setName(taiKhoan.getName());
        t.setUsername(taiKhoan.getUsername());
        t.setPassword(this.passwordEncoder.encode(taiKhoan.getPassword()));
        t.setAvatar(taiKhoan.getAvatar());
        t.setIsActive(taiKhoan.getIsActive());
        t.setUserRole(taiKhoan.getUserRole());
//        t.setMaNv(taiKhoan.getMaNV().getMaNV());
//        t.setTkRole(taiKhoan.getTkRole().getId());
        return t;
    }
    public TaiKhoanDTO toDto1(TaiKhoan taiKhoan){
        TaiKhoanDTO t = new TaiKhoanDTO();
        t.setId(taiKhoan.getId());
        t.setName(taiKhoan.getName());
        t.setUsername(taiKhoan.getUsername());
        t.setPassword(this.passwordEncoder.encode(taiKhoan.getPassword()));
        t.setConfirmPassword(t.getPassword());
        t.setAvatar(taiKhoan.getAvatar());
        t.setIsActive(taiKhoan.getIsActive());
        t.setUserRole(taiKhoan.getUserRole());
        t.setFile(taiKhoan.getFile());
        if (taiKhoan.getMaNV() != null)
            t.setMaNv(taiKhoan.getMaNV().getMaNV());
        else
            t.setMaNv(null);
//        t.setTkRole(taiKhoan.getTkRole().getId());
        return t;
    }
    public List<TaiKhoanDTO> toTKDTOList(List<TaiKhoan> t){
        List<TaiKhoanDTO> taiKhoanDTOS = new ArrayList<>();
        for (TaiKhoan taiKhoan: t)
        {
            TaiKhoanDTO dto = toDto1(taiKhoan);
            if(dto.getIsActive() != false)
                taiKhoanDTOS.add(dto);
        }
        return  taiKhoanDTOS;
    }
    public TaiKhoan toEntity(TaiKhoanDTO taiKhoan){
        TaiKhoan t = new TaiKhoan();
        t.setId(taiKhoan.getId());
        t.setName(taiKhoan.getName());
        t.setUsername(taiKhoan.getUsername());
        t.setPassword(this.passwordEncoder.encode(taiKhoan.getPassword()));
        t.setAvatar(taiKhoan.getAvatar());
        t.setIsActive(taiKhoan.getIsActive());
        t.setUserRole(taiKhoan.getUserRole());
        t.setFile(taiKhoan.getFile());
        return t;
    }
    @Override
    public TaiKhoanDTO addTaiKhoan(TaiKhoanDTO taiKhoanDTO) {
        TaiKhoan taiKhoan = new TaiKhoan();
        taiKhoan = toEntity(taiKhoanDTO);
        if (!taiKhoan.getFile().isEmpty()){
            try {
                Map res =  this.cloudinary.uploader().upload(taiKhoan.getFile().getBytes(), ObjectUtils.asMap("resource_type","auto"));
                taiKhoan.setAvatar(res.get("secure_url").toString());
            }catch (IOException ex) {
                Logger.getLogger(TaiKhoanService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if(taiKhoanDTO.getMaNv() != null) {
            NhanVien nv = taiKhoanRepository.findNVByID(taiKhoanDTO.getMaNv());
            taiKhoan.setMaNV(nv);
        }
        else
        {
            long in = 10;
            NhanVien nv = taiKhoanRepository.findNVByID(in);
            taiKhoan.setMaNV(nv);
        }
//        long t = 1;
//        TaiKhoanRole tk = taiKhoanRepository.findtkByID(t);
//        taiKhoan.setTkRole(tk);
        taiKhoan = taiKhoanRepository.addTaiKhoan(taiKhoan);
        if(taiKhoan == null)
            return null;
        return toDto(taiKhoan) ;
    }

    @Override
    public List<TaiKhoan> getListTaiKhoan(String name) {
        return taiKhoanRepository.getListTaiKhoan(name);
    }

    @Override
    public TaiKhoanDTO getTaiKhoanById(Long id) {
        TaiKhoan taiKhoan = new TaiKhoan();
        taiKhoan = taiKhoanRepository.getTKById(id);
        return toDto1(taiKhoan) ;
    }

    @Override
    public List<TaiKhoanDTO> getAllTk() {
        List<TaiKhoan> taiKhoan = taiKhoanRepository.getAllTK();
        return toTKDTOList(taiKhoan);
    }

    @Override
    public void deleteTaiKhoan(Long id) {
        taiKhoanRepository.deleteTaiKhoan(id);
    }

    @Override
    public List<TaiKhoanDTO> searchTaiKhoan(String kw) {
        List<TaiKhoan> tk = taiKhoanRepository.searchTaiKhoan(kw);
        return toTKDTOList(tk);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<TaiKhoan> list = this.getListTaiKhoan(username);
        if (list.isEmpty())
            throw new UsernameNotFoundException("User does not exist");
        TaiKhoan taiKhoan = list.get(0);

        Set<GrantedAuthority> auth = new HashSet<>();
        auth.add(new SimpleGrantedAuthority(taiKhoan.getUserRole()));
        Util.maNV = taiKhoan.getMaNV().getMaNV();
        return new org.springframework.security.core.userdetails
                .User(taiKhoan.getUsername(),taiKhoan.getPassword(),auth);
    }
}
