package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) {
        //...
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
//            String filename = reader.readLine();
            String filename = "D:\\Study\\Java\\JavaRush\\JavaRushTasks\\JavaRushTasks\\3.JavaMultithreading\\src\\com\\javarush\\task\\task22\\task2209\\test.txt";
            String list = null;

            try (BufferedReader fr = new BufferedReader(new FileReader(filename))){
                while (fr.ready()){
                    list = fr.readLine();
                }
            }
            String[] arrayWords = list.split(" ");

//            System.out.println(Arrays.toString(arrayWords)); // проверка прочитанных слов



            StringBuilder result = getLine(arrayWords);
            System.out.println(result.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public static StringBuilder getLine(String... words) {
        if (words == null || words.length == 0) {
            return new StringBuilder();
        }

        List<String> listsOfWords = new ArrayList<>(Arrays.asList(words));
//        char c = listsOfWords.get(0).charAt(listsOfWords.get(0).length()-1);
//        System.out.println(c);

        StringBuilder result = new StringBuilder(listsOfWords.remove(0));

        for (int i = 0; i < listsOfWords.size(); i++) {
            if (result.charAt(0) == listsOfWords.get(i).charAt(listsOfWords.get(i).length()-1)){
                result.insert(0, listsOfWords.get(i) + " ");
            } else {
                result.append(" ").append(listsOfWords.get(i));
            }
        }

        return result;
    }
}
