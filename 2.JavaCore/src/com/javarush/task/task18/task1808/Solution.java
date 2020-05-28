package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String file1 = sc.nextLine(); // D:\gutkovsky\lectures\Вебинары.docx
        String file2 = sc.nextLine(); // D:\gutkovsky\lectures\file2.docx
        String file3 = sc.nextLine(); // D:\gutkovsky\lectures\file3.docx

        int count = 0;

        try (FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
             FileOutputStream fileOutputStream3 = new FileOutputStream(file3);
             FileInputStream fileInputStream = new FileInputStream(file1)) {

            count = fileInputStream.available();
            byte[] buffer = new byte[count];
            while (fileInputStream.available() > 0) {
                fileInputStream.read(buffer);
                if (count % 2 == 0) {
                    fileOutputStream2.write(buffer, 0, buffer.length / 2);
                    fileOutputStream3.write(buffer, buffer.length / 2, buffer.length / 2);
                } else {
                    fileOutputStream2.write(buffer, 0, buffer.length / 2 + 1);
                    fileOutputStream3.write(buffer, buffer.length / 2 + 1, buffer.length / 2);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
