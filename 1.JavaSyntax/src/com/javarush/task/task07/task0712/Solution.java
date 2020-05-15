package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> dimaList = new ArrayList<>();

        // заполнение списка с клавиатуры
        for (int i = 0; i < 10; i++){
            dimaList.add(reader.readLine());
        }

        int max = 0;
        int min = dimaList.get(0).length();
        int indexOfMax = 0;
        int indexOfMin = 0;

        for (int i = 0; i < dimaList.size(); i++) {
            if (max < dimaList.get(i).length()) {
                max = dimaList.get(i).length();
                indexOfMax = i;
            }

            if (min > dimaList.get(i).length()) {
                min = dimaList.get(i).length();
                indexOfMin = i;
            }
        }

        if (indexOfMax < indexOfMin) System.out.println(dimaList.get(indexOfMax));
        if (indexOfMax > indexOfMin) System.out.println(dimaList.get(indexOfMin));
    }
}
