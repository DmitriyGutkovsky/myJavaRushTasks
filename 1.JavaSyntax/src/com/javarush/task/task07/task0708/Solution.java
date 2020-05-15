package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самая длинная строка
*/

public class Solution {
    private static ArrayList<String> strings;

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
// создание списка - инициализация переменной strings
        strings =  new ArrayList<>();
// добавление 5 элементов в список (считанных с клавиатуры)
        for (int i = 0; i < 5; i ++){
            strings.add(reader.readLine());
        }
        ArrayList<Integer> tempList = new ArrayList<>(); // Лист для хранения длины каждой строки
        for (int i = 0; i < strings.size(); i++){
            String str = strings.get(i);
            char[] temp = str.toCharArray();
            tempList.add(temp.length);
        }
        //нахождение максимальной длины строки
        int max = 0;
        for (int i = 0; i < tempList.size(); i++){
            if (tempList.get(i) > max) max = tempList.get(i);
        }
        // вывод максимальной строки
        for (int i = 0; i < tempList.size(); i++){
            if (max == tempList.get(i)) System.out.println(strings.get(i));
        }

    }
}
