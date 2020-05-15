package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws  Exception{
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        try {

            File file = new File (fileName);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String s;

            while (true) {

                if (!(s = reader.readLine()).equals("exit")) {
                    bufferedWriter.write(s);
                    bufferedWriter.newLine();
                }
                else {
                    bufferedWriter.write(s);
                    break;
                }
            }

            bufferedWriter.close();
            reader.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
