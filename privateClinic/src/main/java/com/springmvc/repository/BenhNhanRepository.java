package com.springmvc.repository;

import com.springmvc.pojo.BenhNhan;

import java.util.List;
import java.util.Map;

public interface BenhNhanRepository {
    BenhNhan getBenhNhanByID(long id);

    List<BenhNhan> SearchBN(String kw);

    List<BenhNhan> getALL(Map<String, String> params);

    BenhNhan addBenhNhan(BenhNhan benhNhan);
}
