package com.springmvc.service.impl;

import com.springmvc.pojo.TaiKhoan;
import com.springmvc.repository.TaiKhoanRepository;
import com.springmvc.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("userDetailsService")
public class TaiKhoanServiceImpl implements TaiKhoanService {
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;
    @Override
    public boolean addTaiKhoan(TaiKhoan taiKhoan) {
        return taiKhoanRepository.addTaiKhoan(taiKhoan);
    }

    @Override
    public List<TaiKhoan> getListTaiKhoan(String name) {
        return taiKhoanRepository.getListTaiKhoan(name);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<TaiKhoan> list = this.getListTaiKhoan(username);
        if (list.isEmpty())
            throw new UsernameNotFoundException("User does not exist");
        TaiKhoan taiKhoan = list.get(0);
        Set<GrantedAuthority> auth = new HashSet<>();
        auth.add(new SimpleGrantedAuthority(taiKhoan.getUserRole()));
        return new org.springframework.security.core.userdetails
                .User(taiKhoan.getUsername(),taiKhoan.getPassword(),auth);
    }
}
