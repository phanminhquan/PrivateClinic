package com.springmvc.repository;

import com.springmvc.pojo.Thuoc;

import java.util.List;
import java.util.Map;


public interface Thuocrepository {
    public List<Thuoc> getListThuoc(Map<String, String> params);

    Thuoc addOrUpdateThuoc(Thuoc thuoc);

    Thuoc getThuocById(long id);

    void deleteThuoc(long id);

    List<Thuoc> searchThuoc(String kw);

    public Long countPromotion(long in);

    List<Object[]> getListThuocByPK(long id);
}
