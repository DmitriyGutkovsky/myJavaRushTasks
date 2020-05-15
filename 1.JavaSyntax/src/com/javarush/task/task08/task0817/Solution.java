package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.Map;
import java.util.*;
import java.util.Iterator;


/* 
Нам повторы не нужны
*/

public class Solution {
    public static Map<String, String> createMap() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<>();
        map.put("Один","Дима");
        map.put("Два","Женя");
        map.put("Три","Тимофей");
        map.put("Четыре", "Настя");
        map.put("Пять", "Настя");
        map.put("Шесть", "Илья");
        map.put("Семь", "Илья");
        map.put("Восемь", "Максим");
        map.put("Девять", "Слава");
        map.put("Десять","Кирилл");
        return map;

    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {

        Map<String, String> copy = new HashMap<>(map);
        Map<String, String> copy2 = new HashMap<>(map);

        // рабочий 1 -й вариант
//        List<String> listOfValue = new ArrayList<>(map.values());
//
//        for (int i = 0; i < listOfValue.size(); i++){
//            int count = 0;
//            listOfValue.get(i);
//            for (Map.Entry<String, String> pair : copy.entrySet()){
//                String value = pair.getValue();
//                if (value.equals(listOfValue.get(i))){
//                    count++;}
//                        if (count > 1) {
//                            removeItemFromMapByValue(map, listOfValue.get(i));
//                            count = 0;
//                        }
//             }
//        }

// 2-й вариант решения
        for (Map.Entry<String, String> pair : copy.entrySet()){
            String value = pair.getValue();
            int count = 0;
                for (Map.Entry<String, String> pair2 : copy2.entrySet()) {
                String value2 = pair2.getValue();
                if (value.equals(value2)) count++;}
                    if (count > 1) {
                        removeItemFromMapByValue(map, value);
                        count = 0;
                    }
                }
        }


    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
        
//        Map<String, String> map1 = createMap();
//        removeTheFirstNameDuplicates(map1);
//
//        for (Map.Entry<String, String> pair : map1.entrySet()){
//            System.out.println(pair.getKey() + " : " + pair.getValue());
//        }

    }
}
