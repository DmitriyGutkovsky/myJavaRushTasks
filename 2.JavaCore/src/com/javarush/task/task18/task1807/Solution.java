package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        int count = 0;

        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            while (fileInputStream.available() > 0) {
                int data = fileInputStream.read();
                if (data == 44) { // code ',' in ASCII table / standard
                    count++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(count);

    }
}
