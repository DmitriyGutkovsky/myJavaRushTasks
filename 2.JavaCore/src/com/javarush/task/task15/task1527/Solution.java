package com.javarush.task.task15.task1527;

/* 
Парсер реквестов
*/

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    //http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
    //http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
    //http://javarush.ru/alpha/index.html?obj=&Amigo&name=Amigo

    public static void main(String[] args) {
        //add your code here
        Scanner sc = new Scanner(System.in);
        String link = sc.nextLine();

        String[] sb = new String[5];
        int i = 0;


        Pattern pattern1 = Pattern.compile("((?<=[?|&])\\b[a-z]*\\b)|((?<==)(\\d.\\d+))"); // |((?<==)(\d.\d+)) - проверка числа после равно
//        final String RegexParameter = "(?<=[?&])\\w+(?=[=&])"; //шаблон для параметров
//        final String RegexForObject = "(?<=(obj=))(\\w+[.]?\\w+)"; // "(?<=(obj=))\\w+[\\.]?\\w+";//шаблон для значения параметра obj


        Matcher matcher = pattern1.matcher(link);
        while (matcher.find()) {
//            System.out.print(link.substring(matcher.start(), matcher.end()) + " ");
            if (link.substring(matcher.start(), matcher.end()).equals("lvl")) {
                System.out.print(link.substring(matcher.start(), matcher.end()) + " ");
                while (matcher.find()) {
                    System.out.print(link.substring(matcher.start(), matcher.end()) + " ");
                }
            } else {
                if (link.substring(matcher.start(), matcher.end()).equals("obj")) {
                    System.out.print(link.substring(matcher.start(), matcher.end()) + " ");
                    sb[i] = link.substring(matcher.start(), matcher.end());
                    i++;

                    while (matcher.find()) {
                        sb[i] = link.substring(matcher.start(), matcher.end());
                        System.out.print(link.substring(matcher.start(), matcher.end()) + " ");
                        i++;
                    }
                }
            }
        }

//        for (String s : sb) {
//            System.out.print(s + " " + "\n");
//        }
//        System.out.println(i);
//
//        if (i != 0) {
//            try {
//                 double number = Double.parseDouble(sb[1]);
////                System.out.println(sb[0] + " " + sb[2]);
//                alert(number);
//
//            } catch (Exception e) {
////                System.out.println(sb[0] + " " + sb[2]);
//                alert(sb[1]);
//            }
//        }


    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
