package com.javarush.task.task22.task2202;

import java.util.ArrayList;
import java.util.List;

/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
//            System.out.println(getPartOfString("JavaRush - лучший сервис."));
//            System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) {
            throw new TooShortStringException();
        }

        char[] chars = string.toCharArray();
        int count = 0;
        List<Integer> indexOfSpace = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                count++;
                indexOfSpace.add(i);
            }
        }

        if (count < 4) {
            throw new TooShortStringException();
        }

        if (count == 4) {
            return string.substring(indexOfSpace.get(0) + 1);
        }

        return string.substring(indexOfSpace.get(0) + 1, indexOfSpace.get(4));
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
