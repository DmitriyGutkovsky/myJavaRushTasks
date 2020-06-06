package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = reader.readLine();
//            String fileName = "D:\\Дима\\JavaRush\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1907\\test.txt";
            try(FileReader fileReader = new FileReader(fileName)){
                int count = 0;
                StringBuilder sb = new StringBuilder();
                while(fileReader.ready()){
                    sb.append((char)fileReader.read());
                }
                String text = sb.toString();
                String[] splitedText = text.split("[\\p{Punct}\\s]+");

                for (String s : splitedText) {
                    if (s.equals("world")){
                        count++;
                    }
                }
                System.out.println(count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
