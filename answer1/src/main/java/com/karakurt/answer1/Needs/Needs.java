package com.karakurt.answer1.Needs;

import java.sql.Date;

public class Needs {
    private static final Date currentDate = new Date(System.currentTimeMillis());

    public static Date getCurrentDate(){
        return currentDate;
    }
}
