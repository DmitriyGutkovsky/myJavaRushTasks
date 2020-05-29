package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String file1 = sc.nextLine(); // D:\Дима\JavaRush\JavaRushTasks\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1818\test1.txt
        String file2 = sc.nextLine(); // D:\Дима\JavaRush\JavaRushTasks\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1818\test2.txt
        String file3 = sc.nextLine(); // D:\Дима\JavaRush\JavaRushTasks\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1818\test3.txt

        try (FileInputStream fis2 = new FileInputStream(file2);
             FileInputStream fis3 = new FileInputStream(file3);
             FileOutputStream fos = new FileOutputStream(file1, true)) {

            while (fis2.available() > 0) {
                fos.write(fis2.read());
            }
            while (fis3.available() > 0) {
                fos.write(fis3.read());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
