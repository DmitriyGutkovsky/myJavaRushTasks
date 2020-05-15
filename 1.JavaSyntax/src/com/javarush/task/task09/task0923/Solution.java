package com.javarush.task.task09.task0923;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str = reader.readLine();

        char[] text = str.toCharArray();

        ArrayList<Character> vowelsList = new ArrayList<>();
        ArrayList<Character> otherSymbols = new ArrayList<>();

        for (int i = 0; i < text.length; i++) {
            if (isSpace(text[i]) == false) {
                if (isVowel(text[i]) == true) {
                    vowelsList.add(text[i]);
                } else {
                    otherSymbols.add(text[i]);
                }
            }
        }

        for (Character vowelsLetters : vowelsList){
            System.out.print(vowelsLetters + " ");
        }
        System.out.println();
        for (Character other : otherSymbols){
            System.out.print(other + " ");
        }

    }

    // метод поиска пробела

    public static boolean isSpace (char c) {
        c = Character.toLowerCase(c);
        String valueofchar =String.valueOf(c);
        String space = " ";
        if (valueofchar.equals(space)) return true;
        else return false;
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels) {  // ищем среди массива гласных
            if (c == d) {
                return true;
            }
        }
        return false;
    }
}