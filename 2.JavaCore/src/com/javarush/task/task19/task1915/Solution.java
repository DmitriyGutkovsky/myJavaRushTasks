package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = reader.readLine();
//            String fileName = "D:\\Дима\\JavaRush\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1915\\test.txt";

            PrintStream out = System.out;

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PrintStream stream = new PrintStream(outputStream);
            System.setOut(stream);

            testString.printSomething();
            String incomingText = outputStream.toString();

            System.setOut(out);

            try(FileOutputStream fos = new FileOutputStream(fileName)){
                fos.write(incomingText.getBytes());
                System.out.println(incomingText);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

