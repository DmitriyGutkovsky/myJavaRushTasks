package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String file1 = args[0];
        String file2 = args[1];

        try (BufferedReader reader = new BufferedReader(new FileReader(file1));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2))) {

            List<String> list = new ArrayList<>();

            while (reader.ready()) {
                String line = reader.readLine();
                String[] words = line.split(" ");
                for (int i = 0; i < words.length; i++) {
                    if (words[i].length() > 6) {
                        list.add(words[i]);
                    }
                }
            }

            for (int i = 0; i < list.size() - 1; i++) {
                bufferedWriter.write(list.get(i) + ",");

            }

            bufferedWriter.write(list.get(list.size() - 1));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
