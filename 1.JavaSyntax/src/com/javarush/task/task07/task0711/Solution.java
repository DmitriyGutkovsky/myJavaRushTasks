package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удалить и вставить
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> dimalist = new ArrayList<>();

        for (int i = 0; i < 5; i++){
            dimalist.add(reader.readLine());
        }

        String temp = null;

        for (int i = 0; i < 13; i++){
            temp = dimalist.get(4);
            dimalist.remove(4);
            dimalist.add(0,temp);
        }

        for (int i = 0; i < dimalist.size(); i++){
            System.out.println(dimalist.get(i));
        }

    }
}
