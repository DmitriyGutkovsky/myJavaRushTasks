package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {

        String key = args[0];

        if (key.equals("-e")) {
            try (FileInputStream fis = new FileInputStream(args[1]);
                 FileOutputStream fos = new FileOutputStream(args[2])) {
                byte[] buffer = new byte[fis.available()];
                while (fis.available() > 0) {
                    fis.read(buffer);
                }
                for (byte b : buffer) {
                    fos.write(b + 1);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if (key.equals("-d")) {
            try (FileInputStream fis = new FileInputStream(args[1]);
                 FileOutputStream fos = new FileOutputStream(args[2])) {
                byte[] buffer = new byte[fis.available()];
                while (fis.available() > 0) {
                    fis.read(buffer);
                }
                for (byte b : buffer) {
                    fos.write(b - 1);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
