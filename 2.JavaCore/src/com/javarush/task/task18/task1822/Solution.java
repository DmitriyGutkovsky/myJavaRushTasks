package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String fileName = reader.readLine(); //D:\Дима\JavaRush\JavaRushTasks\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1822\test.txt

            List<String> list = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))){
                while (br.ready()){
                    list.add(br.readLine());
                }

                for (String value : list) {
                    String[] line = value.split(" ");
                    if (line[0].equals(args[0])) {
                        for (String s : line) {
                            System.out.print(s + " ");
                        }
                        System.out.println();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
