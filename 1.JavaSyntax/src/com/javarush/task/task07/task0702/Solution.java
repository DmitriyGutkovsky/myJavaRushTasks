package com.javarush.task.task07.task0702;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Массив из строчек в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] dimArray = new String[10]; // создание массива длиной 10
//заполнение массива
        for (int i = 0; i < 8; i++ ){
            dimArray[i] = reader.readLine();
        }

//          1-ый вариант решения - выводим существующий массив в обратном порядке
//        for (int i = 9; i >= 0; i--){
//            System.out.println(dimArray[i]);
//        }

//          2-й вариант решения: Копирование в новый массив в оборатном порядке и вывод на печать нового массива
        String[] newDimArray = new String[10];
        for (int i = 0; i < 10 ; i++){
                newDimArray[9-i] = dimArray[i];
        }
// Вывод на печать
        for (int i = 0; i < 10; i++){
            System.out.println(newDimArray[i]);
        }
    }
}