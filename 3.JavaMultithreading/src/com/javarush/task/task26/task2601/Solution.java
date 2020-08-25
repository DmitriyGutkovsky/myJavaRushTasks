package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
//        Integer[] array = {13, 8, 15, 5, 17};
//        Integer[] array = {13, 14, 15, 10, 10, 12, 10, 12, 13};
////        [12, 12, 13, 13, 10, 10, 10, 14, 15]
//        Integer[] sortArray = sort(array);
//        for (int i = 0; i < sortArray.length; i++) {
//            System.out.print(sortArray[i] + ", ");
//        }
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Integer[] array1 = Arrays.copyOf(array, array.length);
        Arrays.sort(array1);
        // нахождение медианы
        Integer mediana;
        if (!(array1.length % 2 == 0)) {
//            System.out.println("не четный");
            mediana = array1[array1.length / 2];
        } else {
//            System.out.println("четный");
            mediana = (array1[array1.length / 2] + array1[array1.length / 2 - 1]) / 2;
        }

        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1.length; j++) {
                int temp;
                if ((Math.abs(mediana - array1[i]) < Math.abs(mediana - array1[j])) ||
                        ((Math.abs(mediana - array1[i]) == Math.abs(mediana - array1[j])) &&
                                (mediana - array1[j] < 0)) ){
                    temp = array1[i];
                    array1[i] = array1[j];
                    array1[j] = temp;
                }
            }
        }
        return array1;
    }
}
