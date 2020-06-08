package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
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
        String text = outputStream.toString();
        System.setOut(out);

        String[] split = text.split("\n");
        int count = 0;

        for (String textLine : split) {
            if (count != 0 && count % 2 == 0) {
                System.out.println("JavaRush - курсы Java онлайн");
                System.out.println(textLine);
                count++;
            } else {
                System.out.println(textLine);
                count++;
            }
        }


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
