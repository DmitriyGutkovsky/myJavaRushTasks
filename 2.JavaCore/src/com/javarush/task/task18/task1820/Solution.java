package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String file1 = sc.nextLine(); // D:\Дима\JavaRush\JavaRushTasks\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1820\test1.txt
        String file2 = sc.nextLine(); // D:\Дима\JavaRush\JavaRushTasks\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1820\test2.txt
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file1)));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2)))) {
            while (reader.ready()){
                sb.append(reader.readLine());
            }
            String text = sb.toString();
            String[] s = text.split(" ");
            for (String s1 : s) {
                sb2.append(Math.round(Double.parseDouble(s1))).append(" ");
            }
            bw.write(sb2.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
