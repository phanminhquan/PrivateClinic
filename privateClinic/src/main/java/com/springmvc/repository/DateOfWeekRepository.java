package com.springmvc.repository;

import com.springmvc.pojo.DateOfWeek;

import java.util.List;

public interface DateOfWeekRepository {
    List<DateOfWeek> listDateOFWeek();
    DateOfWeek getDateOfWeekByID(int id);
}
