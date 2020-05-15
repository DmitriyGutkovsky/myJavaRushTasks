package com.javarush.task.task13.task1318;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // напишите тут ваш код
        
        BufferedReader reader = new BufferedReader(new InputStreamReader (System.in));
        
        String fileName = reader.readLine();
//        System.out.println(fileName);
        
        InputStream inStream = new FileInputStream(fileName);

        while (inStream.available() > 0){
            System.out.print((char)inStream.read());
        }
        
        
        inStream.close();
        reader.close();
    }
}