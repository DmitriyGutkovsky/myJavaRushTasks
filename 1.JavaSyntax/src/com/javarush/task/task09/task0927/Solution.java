package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //напишите тут ваш код
        Map<String, Cat> catMap = new HashMap<>();
        Cat one = new Cat ("one");
        Cat two = new Cat ("two");
        Cat three = new Cat ("three");
        Cat four = new Cat ("four");
        Cat five = new  Cat ("five");
        Cat six = new Cat ("Six");
        Cat seven = new Cat ("seven");
        Cat eight = new Cat ("eight");
        Cat nine = new Cat("nine");
        Cat ten = new Cat ("ten");

        catMap.put("one", one);
        catMap.put("two", two);
        catMap.put("three", three);
        catMap.put("four", four);
        catMap.put("five", five);
        catMap.put("six", six);
        catMap.put("seven", seven);
        catMap.put("eight", eight);
        catMap.put("nine", nine);
        catMap.put("ten", ten);

        return catMap;

    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //напишите тут ваш код

        Set<Cat> setCat = new HashSet<>();

        for (Map.Entry<String, Cat> pair : map.entrySet()){
            Cat value = pair.getValue();
            setCat.add(value);
        }
        return  setCat;

    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
