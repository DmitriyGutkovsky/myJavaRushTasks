package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String fileName = reader.readLine();
//            String fileName = "D:\\Дима\\JavaRush\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1926\\test.txt";

            try( BufferedReader br = new BufferedReader(new FileReader(fileName))){

                while (br.ready()){
                    String line = br.readLine();
                    StringBuilder sb = new StringBuilder(line);
                    System.out.println(sb.reverse());

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
