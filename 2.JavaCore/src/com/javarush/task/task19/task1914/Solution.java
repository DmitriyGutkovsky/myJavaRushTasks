package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream out = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();
        String incomingText = outputStream.toString().trim();

        System.setOut(out);

        String sign = incomingText.replaceAll("[^(\\-+*)]", "");
        String[] split = incomingText.split("\\p{Punct}");
        int a = Integer.parseInt(split[0].trim());
        int b = Integer.parseInt(split[1].trim());


        if (sign.equals("+")) {
            int c = a + b;
            System.out.println(a + " + " + b + " = " + c);
        }
        if (sign.equals("-")) {
            int c = a - b;
            System.out.println(a + " - " + b + " = " + c);
        }
        if (sign.equals("*")) {
            int c = a * b;
            System.out.println(a + " * " + b + " = " + c);

        }


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

