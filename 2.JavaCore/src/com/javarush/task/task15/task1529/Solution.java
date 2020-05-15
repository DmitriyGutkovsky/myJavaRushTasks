package com.javarush.task.task15.task1529;

/* 
Осваивание статического блока
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

    }

    static {
        //add your code here - добавьте код тут
        reset();


    }

    public static CanFly result;

    public static void reset() {
        //add your code here - добавьте код тут
        Scanner sc = new Scanner(System.in);

        String word = sc.nextLine();

        if (word.equals("helicopter")) {
          result = new Helicopter();
        }

        if (word.equals("plane")){
            int numberOfPassengers = sc.nextInt();
            result = new Plane(numberOfPassengers);
        }

        sc.close();


    }
}
