package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws DownloadException {
        Scanner sc = new Scanner(System.in);
        boolean size = false;
        while (!size) {
            String fileName = sc.nextLine();
            try (FileInputStream fis = new FileInputStream(fileName)) {
                int count = fis.available();
                if (count < 1000) {
                    size = true;
                    throw new DownloadException();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static class DownloadException extends Exception {
    }
}
