package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
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

        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            while (fileReader.ready()) {
                String line = fileReader.readLine();
                String[] splittedLine = line.trim().split(" ");
                if (map.containsKey(splittedLine[0])) {
                    double salary = map.get(splittedLine[0]);
                    double sumSalary = salary + Double.parseDouble(splittedLine[1]);
                    map.put(splittedLine[0], sumSalary);
                } else {
                    map.put(splittedLine[0], Double.parseDouble(splittedLine[1]));
                }
            }

            for (Map.Entry<String, Double> pair : map.entrySet()) {
                String name = pair.getKey();
                double salary = pair.getValue();
                System.out.println(name + " " + salary);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
