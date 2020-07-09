package com.javarush.task.task22.task2211;


import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        String firstFile = args[0];
        String seconfFile = args[1];

        Charset windows = Charset.forName("Windows-1251");
        Charset utf = Charset.forName("UTF-8");

        try (FileInputStream inputStream = new FileInputStream(firstFile);
             FileOutputStream outputStream = new FileOutputStream(seconfFile)) {

            byte[] buffer = new byte[1000];

            while (inputStream.available() > 0) {
                inputStream.read(buffer);
                String string = new String(buffer, windows);
                buffer = string.getBytes(utf);
                outputStream.write(buffer);
            }
        }
    }
}
