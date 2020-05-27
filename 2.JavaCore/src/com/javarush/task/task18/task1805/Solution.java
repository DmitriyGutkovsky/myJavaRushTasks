package com.javarush.task.task18.task1805;

/* 
Сортировка байт
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static int getPosition(int d, int [] arrayByte) {
        for (int i = 0; i < arrayByte.length; i++) {
            if (arrayByte[i] == d) return i;
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] arrayByte = {};

        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();

        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            while (fileInputStream.available() > 0){
                int data = fileInputStream.read();
                int position = getPosition(data, arrayByte);
                if (position < 0){
                    int lastElement = arrayByte.length;
                    arrayByte = Arrays.copyOf(arrayByte, lastElement+1);
                    arrayByte[lastElement] = data;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Arrays.sort(arrayByte);

        for (int value : arrayByte) {
            System.out.print(value + " ");
        }
    }
}
