package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        //напишите тут ваш код
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {6, 7};
        int[] array3 = {8, 9, 10 , 11};
        int[] array4 = {12, 13, 14, 15, 16, 17, 18};
        int[] array5 = new int [0];

        ArrayList<int []> createdliest = new ArrayList<>();
        createdliest.add(array1);
        createdliest.add(array2);
        createdliest.add(array3);
        createdliest.add(array4);
        createdliest.add(array5);

        return  createdliest;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
