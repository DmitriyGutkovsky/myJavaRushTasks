package com.javarush.task.task18.task1823;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true){
            String fileName = sc.nextLine();
            if(fileName.equals("exit")) break;
            ReadThread readThread = new ReadThread(fileName);
            readThread.start();
        }
    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }

        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {

            Map<Byte, Integer> map = new HashMap<>();
            int max = Integer.MIN_VALUE;
            byte b = Byte.MIN_VALUE;

            try(FileInputStream fis = new FileInputStream (fileName)) {

                byte[] data = new byte[fis.available()];
                while (fis.available()>0){
                    fis.read(data);
                }

                for (int i = 0; i < data.length; i++) {
                    if (map.containsKey(data[i])){
                        int count = map.get(data[i]) + 1;
                        map.put(data[i], count);
                    } else{
                        map.put(data[i], 1);
                    }
                }

                for(Map.Entry<Byte, Integer> entry : map.entrySet()){
                    if(entry.getValue() > max){
                        max = entry.getValue();
                        b = entry.getKey();
                    }
                }

                synchronized (resultMap){
                    resultMap.put(fileName, (int) b);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
