package com.javarush.task.task08.task0827;



import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("February 2 2013"));
    }

    public static boolean isDateOdd(String date) {

        Date currentData = new Date(date);
//        System.out.println(currentData.getYear());
//        System.out.println(currentData.getMonth());
//        System.out.println(currentData.getDate());

        Calendar newCalendar = new GregorianCalendar();
        newCalendar.set(Calendar.YEAR, currentData.getYear());
        newCalendar.set(Calendar.MONTH, currentData.getMonth());
        newCalendar.set(Calendar.DAY_OF_MONTH, currentData.getDate());

        int day = newCalendar.get(newCalendar.DAY_OF_YEAR) ;
//        System.out.println("день для расчета" + day);
//        System.out.println(" Date: " + newCalendar.getTime());

        if (day%2 != 0) return true;
        else return false;

    }
}
