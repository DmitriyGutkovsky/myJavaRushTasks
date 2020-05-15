package com.javarush.task.task06.task0606;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String number = reader.readLine();

        char[] listOfNumbers = number.toCharArray(); // записываю считанное число в массив char

//         вывод на печать каждого элемента массива (лдя проверки )
//        for (int i = 0; i < listOfNumbers.length; i++){
//            System.out.println("Element [" + i + "]: " + listOfNumbers[i]);
//        }
        for (int i = 0; i < listOfNumbers.length; i++){
            int n = Character.getNumericValue(listOfNumbers[i]);
            if ((n%2) == 0) even++;
            else odd++;

        }
        System.out.println("Even: " + even + " Odd: " + odd);
    }
}
