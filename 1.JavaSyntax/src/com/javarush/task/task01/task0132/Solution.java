package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        //напишите тут ваш код
        int sum;
        int sto = number/100;
        int dec = (number - sto*100)/10;
        int edin = number - sto*100 - dec*10;
        sum = sto + dec + edin;
        return sum;

    }
}