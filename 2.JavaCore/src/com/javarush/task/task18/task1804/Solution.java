package com.javarush.task.task18.task1804;

/* 
Самые редкие байты
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

    public static void main(String[] args) throws Exception {
        int[] arrayByte = {};
        int[] count = {};

        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();

        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            while (fileInputStream.available() > 0) {
                int data = fileInputStream.read();
                int position = getPosition(data, arrayByte);
                if (position >= 0) {
                    count[position]++;
                } else {
                    int lastElement = arrayByte.length;
                    arrayByte = Arrays.copyOf(arrayByte, lastElement+1);
                    arrayByte[lastElement] = data;
                    count = Arrays.copyOf(count, lastElement+1);
                    count[lastElement] = 1;
                }
            }
         } catch (IOException e) {
            e.printStackTrace();
        }

        int minRepeat = Integer.MAX_VALUE;

        for (int value : count) {
            if (value < minRepeat) {
                minRepeat = value;
            }
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] == minRepeat){
                System.out.print(arrayByte[i] + " ");
            }
        }
    }
}
