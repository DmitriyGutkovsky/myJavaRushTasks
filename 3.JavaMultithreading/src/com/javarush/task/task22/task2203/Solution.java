package com.javarush.task.task22.task2203;

import java.util.ArrayList;
import java.util.List;

/*
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {

        if (string == null) throw new TooShortStringException();

        char[] chars = string.toCharArray();
        int count = 0;
        List<Integer> indexOfTab = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '\t') {
                count++;
                indexOfTab.add(i);
            }
        }

        if (count < 2) {
            throw new TooShortStringException();
        }

        return string.substring(indexOfTab.get(0) + 1, indexOfTab.get(1));
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
//        System.out.println(getPartOfString(null));
    }
}
