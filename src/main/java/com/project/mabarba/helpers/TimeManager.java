package com.project.mabarba.helpers;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class TimeManager {

    public TimeManager() {
    }
    public static long timeToSecond(Time time){
        return time.getTime()/1000;
    }
    public static long timestampToSecond(Timestamp time){
        return time.getTime()/1000;
    }
    public static long dateToSecond(Date date){
        Timestamp time = new Timestamp(date.getTime());
        return time.getTime()/1000;
    }
    public static long substractTimestamp(Timestamp time1, Timestamp time2){
        return (time1.getTime()-time2.getTime())/1000;
    }
    public static long substractDate(Date date1, Date date2){
        return TimeManager.dateToSecond(date1)-TimeManager.dateToSecond(date2);
    }
    public static long hourToSecond(String hour){
        try{
            long heure = Long.parseLong(hour.split("h")[0])*3600;
            long minutes = Long.parseLong(hour.split("h")[1])*60;
            return heure+minutes;
        }catch(NumberFormatException e){
            e.getMessage();
        }
        return 0;
    }
    public static String secondToHour(long second){
        if(second%3600==0){
            return second/3600+"h00";
        }
        /*System.out.println("second = "+second);
        System.out.println("second%3600 = "+second%3600);*/
        return second/3600+"h"+(second%3600)/60;
    }
    public static Timestamp stringToTimestamp(String hour){
        long time = TimeManager.hourToSecond(hour)*1000;
        return new Timestamp(time);
    }
    public static Date stringToDate(String hour){
        long time = TimeManager.hourToSecond(hour)*1000;
        return new Date(time);
    }
    public static Time stringToTime(String hour){
        long time = TimeManager.hourToSecond(hour)*1000;
        return new Time(time);
    }
}
