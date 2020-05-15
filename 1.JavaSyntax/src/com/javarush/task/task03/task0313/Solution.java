package com.javarush.task.task03.task0313;

/* 
Мама мыла раму
*/

import java.sql.SQLOutput;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        String [] array1 = {"Мама","Мыла","Раму"};
            /*for (int i = 0; i < array1.length; i++){
                System.out.print(array1[i]);
            } */
            for (int i = 0; i < array1.length; i++){
                for (int j = 0; j < array1.length; j++){
                    for (int z = 0; z < array1.length; z++){
                        if ( i!=j && j!=z && i != z)
                            System.out.println(array1[i]+array1[j]+array1[z]);
                    }
                }
            }

        }
    }

