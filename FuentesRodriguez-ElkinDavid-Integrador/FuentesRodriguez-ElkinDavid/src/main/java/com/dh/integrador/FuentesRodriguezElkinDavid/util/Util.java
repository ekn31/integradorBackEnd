package com.dh.integrador.FuentesRodriguezElkinDavid.util;

import java.sql.Timestamp;
import java.util.Date;

public class Util {

    public static Timestamp dateToTimestam(Date date){
        Timestamp timestamp = new Timestamp(date.getTime());
            return timestamp;
        }

        public static java.sql.Date utilDateToSqlDate(Date utilDate){
        long timeInMilliSeconds = utilDate.getTime();
        java.sql.Date sqlDate = new java.sql.Date(timeInMilliSeconds);
        return sqlDate;
    }
}
