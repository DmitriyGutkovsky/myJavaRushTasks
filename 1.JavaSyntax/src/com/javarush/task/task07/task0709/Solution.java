package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 5; i++){
            list.add(reader.readLine());
        }

        ArrayList<Integer> tempList = new ArrayList<>(); // Лист для хранения длины каждой строки
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            char[] temp = str.toCharArray();
            tempList.add(temp.length);
        }

//        нахожу минимальные строки

        int min = tempList.get(0);
        for (int i = 0; i < tempList.size(); i++){
            if (tempList.get(i) < min) min = tempList.get(i);
        }
//         вывод напечать минимальных строк

        for (int i = 0; i < tempList.size(); i++){
            if (min == tempList.get(i)) System.out.println(list.get(i));
        }


    }
}
