package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleMap();
        printPeopleMap(map);
    }

    public static Map<String, String> createPeopleMap() {
        //напишите тут ваш код
        Map<String, String>  peopleMap = new HashMap<>();
        peopleMap.put("one", "Dima");
        peopleMap.put("two", "Nastya");
        peopleMap.put("three", "Jenya");
        peopleMap.put("four", "Timosha");
        peopleMap.put("five", "Kolya");
        peopleMap.put("one", "Dima1");
        peopleMap.put("two", "Nastya1");
        peopleMap.put("three", "Jenya1");
        peopleMap.put("four", "Timosha1");
        peopleMap.put("five", "Kolya1");

        return peopleMap;
    }

    public static void printPeopleMap(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
