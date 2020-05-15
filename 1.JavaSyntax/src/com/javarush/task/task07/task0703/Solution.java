package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] lines = new String[10];
        int[] numbers = new int[10];
//        заполнение массива строк
        for (int i = 0; i < 10; i++){
            lines[i] = reader.readLine();
        }
//        каждый элемент массива lines  преобразую в массив чаров и занашу длину массива чаров в i-й элемент массива numbers
        for (int i = 0; i < 10; i++){
            String str = lines[i];
            char[] temp = str.toCharArray();
            numbers[i] = temp.length;
        }
// вывод на печать массива numbers , каждый элемент с новой строки
        for ( int i = 0; i < numbers.length; i++) {
            System.out.println((numbers[i]));
        }

    }
}
