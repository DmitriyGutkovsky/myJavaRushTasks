package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String file1 = sc.nextLine(); // D:\Дима\JavaRush\JavaRushTasks\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1819\test1.txt
        String file2 = sc.nextLine(); // D:\Дима\JavaRush\JavaRushTasks\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1819\test2.txt

        try (FileInputStream fis1 = new FileInputStream(file1);
             FileInputStream fis2 = new FileInputStream(file2)) {

            byte[] array = new byte[fis1.available()];
            while (fis1.available() > 0) {
                fis1.read(array);
            }
            try (FileOutputStream fos = new FileOutputStream(file1)) {
                while (fis2.available() > 0) {
                    fos.write(fis2.read());
                }
                fos.write(array);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
