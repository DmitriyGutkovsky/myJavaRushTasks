package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;
import java.util.*;
import java.util.Iterator;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        //напишите тут ваш код
        Map<String, Integer> map = new HashMap<>();
        map.put("first", 600);
        map.put("Second", 700);
        map.put("Three", 500);
        map.put("four", 400);
        map.put("six", 300);
        map.put("seven", 200);
        map.put("eight", 100);
        map.put("Nine", 800);
        map.put("Ten", 900);
        map.put("five", 1000);
        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        //напишите тут ваш код
        Map<String, Integer> copy = new HashMap(map);
        for (Map.Entry<String, Integer> pair : copy.entrySet()){
            String key = pair.getKey();
            int value = pair.getValue();
            if (value < 500) map.remove(key, value);
        }
        
    }

    public static void main(String[] args) {
     Map<String, Integer> map1 = createMap();
         removeItemFromMap(map1);
        
         for (Map.Entry<String, Integer> pair : map1.entrySet()){
             System.out.println(pair.getKey() + " : " + pair.getValue());
         }
    }
}