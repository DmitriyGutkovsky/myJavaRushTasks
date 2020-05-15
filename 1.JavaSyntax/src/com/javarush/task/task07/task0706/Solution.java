package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] houseList = new int[15];
        // заполнение массива с клавиатуры
        for (int i = 0; i < houseList.length; i++){
            houseList[i] = Integer.parseInt(reader.readLine());
        }

        int sumForEvenHouses = 0; //  сумма жителей для домов с четными номерами
        int sumForOddHouses = 0; // сумма жителей для домой с нечетными номерами

        for (int i = 0; i < houseList.length; i++){
            if (i%2 == 0) sumForEvenHouses = sumForEvenHouses + houseList[i];
            else sumForOddHouses = sumForOddHouses + houseList[i];
        }

        if (sumForEvenHouses > sumForOddHouses) System.out.println("В домах с четными номерами проживает больше жителей.");
        else System.out.println("В домах с нечетными номерами проживает больше жителей.");



    }
}
