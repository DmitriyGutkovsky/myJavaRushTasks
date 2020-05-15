package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> incomingList = new ArrayList<>();

        // записываем введеные строки в список
        while (true) {
            String value = reader.readLine();
            if (value.equals("exit")) break;
            else incomingList.add(value);
        }
//         вывод списка на печать - для проверки
//        for (String values : incomingList){
//            System.out.println(values);
//        }
        for (int i = 0; i < incomingList.size(); i++) {
            String item = incomingList.get(i);
            if (isNumber(item) == true && item.contains(".")) {
                double d = Double.parseDouble(item);
                print(d);
            } else if (isNumber(item) == true && shortNumber(item) == true) {
                short n = Short.parseShort(item);
                print(n);
            } else if (isNumber(item) == true && integerNumber(item) == true) {
                int intNumber = Integer.parseInt(item);
                print(intNumber);
            }
            if (isNumber(item) == false) print(item);
            // проверка методда isNumber()
//            if (isNumber(item) == true) {
//                int n = Integer.parseInt(item);
//                print(n);
//            } else print(item);
        }


    }

    public static boolean isNumber(String text) {
        return text.matches("-?\\d+(\\.\\d+)?");
//        try {
//            Double.parseDouble(text);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
    }

    public static boolean shortNumber(String text) {
        try {
            short shortNumber = Short.parseShort(text);
//            System.out.println( "short text = " + text);
            if (shortNumber > 0 && shortNumber < 128) return true;
            else return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean integerNumber(String text) {
        try {
            int m = Integer.parseInt(text);
            if (m <= 0 || m >= 128) {
                return true;
            } else return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
