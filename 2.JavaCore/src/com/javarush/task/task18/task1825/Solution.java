package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> list = new ArrayList<>();

        for (; ; ) {
            String fileName = sc.nextLine();
            if (fileName.equals("end")) {
                break;
            }
            list.add(fileName);
        }

        String tempName = list.get(0);
        String[] splited = tempName.split(".part");

        String fileForWrite = splited[0];

        Map<Integer, String> map = new TreeMap<>();

        for (String s : list) {
            String[] splitName = s.split(".part");
            int part = Integer.parseInt(splitName[1]);
            String file = splitName[0];
            map.put(part, file);
        }

        for (Map.Entry<Integer, String> pair : map.entrySet()) {
            Integer key = pair.getKey(); // # of the part
            String value = pair.getValue(); // name of the part
            String readFile = value + ".part" + key;
            try (FileInputStream fis = new FileInputStream(readFile);
                 FileOutputStream fos = new FileOutputStream(fileForWrite, true)) {
                byte[] buffer = new byte[fis.available()];
                while (fis.available() > 0) {
                    fis.read(buffer);
                }

                fos.write(buffer);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
