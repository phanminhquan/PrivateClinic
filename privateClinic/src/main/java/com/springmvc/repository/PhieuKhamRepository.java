package com.springmvc.repository;

import com.springmvc.pojo.PhieuKham;

import java.util.List;
import java.util.Map;

public interface PhieuKhamRepository {
    List<Object[]> listObjPayUI(Map<String,String> param);
    PhieuKham getPhieuKhamByID(long id);
}
