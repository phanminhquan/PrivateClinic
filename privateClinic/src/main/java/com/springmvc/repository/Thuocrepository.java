package com.springmvc.repository;

import com.springmvc.pojo.Thuoc;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface Thuocrepository {
    public List<Thuoc> getListThuoc();
}
