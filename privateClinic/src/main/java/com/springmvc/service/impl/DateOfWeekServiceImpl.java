package com.springmvc.service.impl;


import com.springmvc.dto.DateOfWeekDTO;
import com.springmvc.pojo.DateOfWeek;
import com.springmvc.repository.DateOfWeekRepository;
import com.springmvc.service.DateOfWeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class DateOfWeekServiceImpl implements DateOfWeekService {

    @Autowired
    private DateOfWeekRepository dateOfWeekRepository;
    private DateOfWeekDTO toDTO(DateOfWeek entity){
        DateOfWeekDTO date = new DateOfWeekDTO();
        if(entity.getId() !=null){
            date.setId(entity.getId());
        }
        date.setDateOfWeek(entity.getDateOfWeek());
        return date;
    }
    List<DateOfWeekDTO> toListDto(List<DateOfWeek> list){
        List<DateOfWeekDTO> dtoList = new ArrayList<>();
        for (DateOfWeek date : list){
            dtoList.add(toDTO(date));
        }
        return dtoList;
    }

    @Override
    public List<DateOfWeekDTO> getListDateOfWeek() {
        return this.toListDto(dateOfWeekRepository.listDateOFWeek());
    }

    @Override
    public DateOfWeekDTO getDateOfWeekById(int id) {
        return toDTO(dateOfWeekRepository.getDateOfWeekByID(id));
    }


}
