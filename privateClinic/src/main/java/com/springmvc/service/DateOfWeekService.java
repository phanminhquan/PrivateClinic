package com.springmvc.service;

import com.springmvc.dto.DateOfWeekDTO;

import java.util.List;

public interface DateOfWeekService {
    List<DateOfWeekDTO> getListDateOfWeek();
    DateOfWeekDTO getDateOfWeekById(int id);
}
