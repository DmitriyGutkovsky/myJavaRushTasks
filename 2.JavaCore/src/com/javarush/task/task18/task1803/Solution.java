package com.javarush.task.task18.task1803;

/* 
Самые частые байты
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static int[] arrayByte = {};
    private static int[] count = {};

    private static int getPosition(Integer d) {
        for (int i = 0; i < arrayByte.length; i++) {
            if (arrayByte[i] == d) return i;
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();

        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            while (fileInputStream.available() > 0) {
                int data = fileInputStream.read();
                int position = getPosition(data);
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
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        int maxRepeat = 0;

        for (int value : count) {
            if (value > maxRepeat) {
                maxRepeat = value;
            }
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] == maxRepeat){
                System.out.print(arrayByte[i] + " ");
            }
        }
    }
}
