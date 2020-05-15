package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String  input = reader.readLine();
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        Date inputData = new Date();
        inputData = format1.parse(input);

//        System.out.println(inputData);

        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        System.out.println(dateFormat.format(inputData).toUpperCase());
    }
}
