package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.*;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) {
        //D:\Дима\JavaRush\JavaRushTasks\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1817\test.txt
        String fileName = args[0];
        Locale.setDefault(Locale.US);
        double countTotal = 0;
        double countSpace = 0;

        try (final FileInputStream fis = new FileInputStream(fileName)){
            while (fis.available() > 0){
                countTotal++;
                if (fis.read() == ' ') countSpace++;
            }
         } catch (IOException e) {
            e.printStackTrace();
        }

        double average = countSpace / countTotal * 100;
        System.out.printf("%.2f", average);

    }
}
