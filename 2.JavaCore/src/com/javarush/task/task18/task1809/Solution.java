package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String file1 = sc.nextLine(); // D:\Дима\JavaRush\JavaRushTasks\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1809\test1.txt
        String file2 = sc.nextLine(); // D:\Дима\JavaRush\JavaRushTasks\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1809\test2.txt
        int count;
        try (FileInputStream fileInputStream = new FileInputStream(file1);
             FileOutputStream fileOutputStream = new FileOutputStream(file2)) {
            count = fileInputStream.available();
            byte[] buffer1 = new byte[count];
            byte[] buffer2 = new byte[count];
            while (fileInputStream.available() > 0){
                fileInputStream.read(buffer1);
            }
            int j = 0;
            for (int i = buffer1.length - 1; i >= 0; i--) {
                buffer2[j] = buffer1[i];
                j++;
            }
                fileOutputStream.write(buffer2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
