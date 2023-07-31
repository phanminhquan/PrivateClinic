package com.springmvc.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public static Date dateParse(String date) throws ParseException {
        return simpleDateFormat.parse(date);
    }
}
