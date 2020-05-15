package com.javarush.task.task06.task0609;

/* 
Расстояние между двумя точками
*/

import static java.lang.StrictMath.sqrt;

public class Util {
    public static double getDistance(int x1, int y1, int x2, int y2) {
        //напишите тут ваш код
        double a = Math.pow((x2 - x1), 2);
        double b = Math.pow((y2 - y1), 2);
        double c =  Math.sqrt((a+b));
        return c;


    }

    public static void main(String[] args) {

    }
}
