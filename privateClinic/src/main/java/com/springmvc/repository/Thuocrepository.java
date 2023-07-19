package com.springmvc.repository;

import com.springmvc.pojo.Thuoc;

import java.util.List;


public interface Thuocrepository {
    public List<Thuoc> getListThuoc();

    Thuoc createThuoc (Thuoc thuoc);
}
