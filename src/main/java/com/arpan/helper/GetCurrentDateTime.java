package com.arpan.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetCurrentDateTime {
    public static String getCurrentDateTime(String dateTimeFormat) {
        SimpleDateFormat formatter = new SimpleDateFormat(dateTimeFormat);
        Date date = new Date();
        return formatter.format(date);
    }
}