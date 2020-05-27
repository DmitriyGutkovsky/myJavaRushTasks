package com.javarush.task.task18.task1802;

/* 
Минимальный байт
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        int maxData = 127;
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            while (fileInputStream.available() > 0) {
                int data = fileInputStream.read();
                if (data < maxData) {
                    maxData= data;
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println(maxData);
    }
}
