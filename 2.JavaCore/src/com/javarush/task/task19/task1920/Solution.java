package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        String fileName = args[0];
        Map<String, Double> map = new TreeMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {

                String line = reader.readLine();
                String[] data = line.trim().split(" ");

                if (map.containsKey(data[0])) {
                    map.put(data[0], (map.get(data[0]) + Double.parseDouble(data[1])));
                } else {
                    map.put(data[0], Double.parseDouble(data[1]));
                }
            }

            double max = Double.MIN_VALUE;

            for (Map.Entry<String, Double> pair : map.entrySet()) {
                if (pair.getValue() > max) {
                    max = pair.getValue();
                }
            }

            for (Map.Entry<String, Double> pair : map.entrySet()) {
                if (pair.getValue() == max) {
                    System.out.println(pair.getKey());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
