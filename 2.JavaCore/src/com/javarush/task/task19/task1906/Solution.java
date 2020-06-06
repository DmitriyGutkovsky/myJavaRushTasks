package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String file1 = reader.readLine();
            String file2 = reader.readLine();

            try (FileReader fileReader = new FileReader(file1);
                 FileWriter fileWriter = new FileWriter(file2)) {

                int count = 1;

                while (fileReader.ready()) {
                    int data = fileReader.read();
                    if (count % 2 == 0) {
                        fileWriter.write(data);
                    }
                    count++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
