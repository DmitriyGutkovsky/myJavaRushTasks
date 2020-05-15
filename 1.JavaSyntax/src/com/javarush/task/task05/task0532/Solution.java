package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код

        int n = Integer.parseInt(reader.readLine());

        if (n > 0){
            int maximum = 0;
            int[] mas = new int [n];
            for (int i = 0; i < mas.length; i++) { // заполняю массив длиной n  чисел
                mas[i] = Integer.parseInt(reader.readLine());
//                System.out.println(mas[i]);
            }
//            сортировка методом пузырьков по возрастанию
            int temp;
            boolean isSorted = false;

            while (!isSorted){
                isSorted = true;
                for (int i = 0; i < mas.length-1; i++){
//                   int maximum = mas[i];
                    if (mas[i] < mas[i+1]){
                            isSorted = false;
                            temp = mas[i];
                            mas[i] = mas[i+1];
                            mas[i+1] = temp;

                    }
                }
            }
//            maximum = mas[0];
            System.out.println(mas[0]);
        }



    }
}
