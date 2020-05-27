package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

class Test {

    public static void main(String[] args) {
        String t = "15/04/1990";
//        String t = "04/15/1990";
//        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, new Locale("en", "FR"));
//        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.FRENCH);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat newFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Date d = null;
        try{
//            d = df.parse(t);
            d = sdf.parse(t);
            String nd = newFormat.format(d);
            System.out.println(d);
            System.out.println(nd);
        } catch (ParseException e) {
            System.out.println(e);
        }

    }

}
