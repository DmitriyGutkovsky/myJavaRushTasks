package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static Set<Integer> createSet() {
        // напишите тут ваш код
        Set<Integer> createSet = new HashSet<>();
        createSet.add(1);
        createSet.add(2);
        createSet.add(3);
        createSet.add(4);
        createSet.add(5);
        createSet.add(6);
        createSet.add(7);
        createSet.add(8);
        createSet.add(9);
        createSet.add(10);
        createSet.add(11);
        createSet.add(12);
        createSet.add(13);
        createSet.add(14);
        createSet.add(15);
        createSet.add(16);
        createSet.add(17);
        createSet.add(18);
        createSet.add(19);
        createSet.add(20);

        return createSet;

    }

    public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {
        // напишите тут ваш код
        Iterator<Integer> iterator = set.iterator();

        while (iterator.hasNext()){
            Integer n = iterator.next();
            if (n > 10) set.remove(n);
        }

        return set;

    }

    public static void main(String[] args) {

        removeAllNumbersGreaterThan10(createSet());

    }
}
