package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List <Integer> listOfNumbers = new ArrayList();
        
        // считывание чисел с клавиатуры и добавление их в список listOfNumbers
        for (int i = 0; i < 10; i++){
            listOfNumbers.add(Integer.parseInt(reader.readLine()));
        }
        
        int count = 1; // подсчет самой большое последовательности одинаковых чисел
        int posl = 0; // для хранения числа последовательностей
        int result = 0;

        for (int i = 1; i < 10; i++){
            if (listOfNumbers.get(i).equals(listOfNumbers.get(i-1))){
                count++;
                if (posl < count) posl = count; // в posl записываем значение только если переменная меньше счетчика
            }
            else {
                    count = 1;
                }
            if (posl < count){
                result = count;}
                else result = posl;
        }
        System.out.println(result);
    }
}