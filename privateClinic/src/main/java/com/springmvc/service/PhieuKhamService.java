package com.springmvc.service;


import com.springmvc.dto.PhieuKhamDTO;


import java.rmi.MarshalledObject;
import java.util.List;
import java.util.Map;

public interface PhieuKhamService {
    List<Object[]> getListObjUI(Map<String,String> map);
}
