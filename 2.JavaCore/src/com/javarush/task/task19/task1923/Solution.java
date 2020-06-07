package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        String file1 = args[0];
        String file2 = args[1];

        try (BufferedReader reader = new BufferedReader(new FileReader(file1));
             BufferedWriter writer = new BufferedWriter(new FileWriter(file2))) {

            while (reader.ready()) {
                String line = reader.readLine();
                String[] split = line.trim().split(" ");
                Pattern pattern = Pattern.compile("\\d+");
                for (String s : split) {
                    Matcher matcher = pattern.matcher(s);
                    if (matcher.find()) {
                        writer.write(s + " ");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
