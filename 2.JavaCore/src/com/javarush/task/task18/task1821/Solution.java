package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        String file = args[0];
        List<Character> list = new ArrayList<>();
        Map<Character, Integer> map = new TreeMap<>();

        try (BufferedReader fis = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
//        try (FileInputStream fis = new FileInputStream(file)) {
//            while (fis.available() > 0) {
            while (fis.ready()) {
                list.add((char) fis.read());
            }

            for (int i = 0; i < list.size(); i++) {
                int count = Collections.frequency(list, list.get(i)); // частота встречания элемента list.get(i) в коллекции list
                map.put(list.get(i), count);
            }

            for (Map.Entry<Character, Integer> pair : map.entrySet()) {
                Character key = pair.getKey();
                Integer value = pair.getValue();
                System.out.println(key + " " + value);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
