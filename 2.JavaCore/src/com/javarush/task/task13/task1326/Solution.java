package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // read file name
        try {
            String fileName = reader.readLine();
            InputStream inStream = new FileInputStream(fileName);
            BufferedReader readBuffer = new BufferedReader(new InputStreamReader(inStream));

            ArrayList<Integer> wholeList = new ArrayList<>();

            while (readBuffer.ready()){
                int n = Integer.parseInt(readBuffer.readLine());
                wholeList.add(n);
            }
            // check arraylist
//            for (int n : wholeList){
//                System.out.println(n);
//            }
            Collections.sort(wholeList);
            for  (int i = 0; i < wholeList.size(); i++){
                if ((wholeList.get(i)%2) == 0) System.out.println(wholeList.get(i));
            }
            reader.close();
            readBuffer.close();
            inStream.close();
        }
        catch (Exception e){
            System.out.println("incorrect file name or other exception");
        }








    }
}
