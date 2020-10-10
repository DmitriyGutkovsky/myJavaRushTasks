package com.javarush.task.task30.task3001;

import java.math.BigInteger;

/* 
Конвертер систем счислений
*/
public class Solution {
    public static void main(String[] args) {
        Number number = new Number(NumberSystemType._10, "6");
        Number result = convertNumberToOtherNumberSystem(number, NumberSystemType._2);
        System.out.println(result);    //expected 110

        number = new Number(NumberSystemType._16, "6df");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._8);
        System.out.println(result);    //expected 3337

        number = new Number(NumberSystemType._16, "abcdefabcdef");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._16);
        System.out.println(result);    //expected abcdefabcdef
    }

    public static Number convertNumberToOtherNumberSystem(Number number, NumberSystem expectedNumberSystem) {
        //напишите тут ваш код
        Number result = null;
        int system = number.getNumberSystem().getNumberSystemIntValue();
        try {
            String numString = "" + new BigInteger(number.getDigit(), system);
            BigInteger num = new BigInteger(numString);
            String s = num.toString(expectedNumberSystem.getNumberSystemIntValue());
            result = new Number(expectedNumberSystem, s);
        } catch (Exception e) {
            throw  new NumberFormatException();
        }

        return result;
    }
}
