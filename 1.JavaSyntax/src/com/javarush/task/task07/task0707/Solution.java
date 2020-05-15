package com.javarush.task.task07.task0707;

import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();
// добавление в список
        list.add("Dima");
        list.add("Kolay");
        list.add("Vasya");
        list.add("Olya");
        list.add("Bob");
// выаод на экран размера списка
        System.out.println(list.size());
// вывод на экран элементов списка
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }


    }
}
