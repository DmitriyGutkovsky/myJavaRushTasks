package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String file1 = reader.readLine();
            String file2 = reader.readLine();
//            String file1 = "D:\\Дима\\JavaRush\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1908\\test1.txt";
//            String file2 = "D:\\Дима\\JavaRush\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1908\\test2.txt";

            try (BufferedReader fileReader = new BufferedReader(new FileReader(file1));
                 BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file2))) {
                StringBuilder sb = new StringBuilder();
                while (fileReader.ready()) {
                    sb.append(fileReader.readLine());
                }

                String text = sb.toString();
                String[] splitText = text.split(" ");

                for (String s : splitText) {
                    try {
                        int number = Integer.parseInt(s);
                        fileWriter.write(number + " ");
                    } catch (NumberFormatException | IOException ignored) {
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
