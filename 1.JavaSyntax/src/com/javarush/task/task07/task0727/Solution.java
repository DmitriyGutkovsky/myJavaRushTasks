package com.javarush.task.task07.task0727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Меняем функциональность
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> strings = new ArrayList<String>();
        while (true) {
            String string = reader.readLine();
            if (string == null || string.isEmpty()) break;
            strings.add(string);
        }
/*      старый код
        ArrayList<String> resultStrings = new ArrayList<String>();
        for (int i = 0; i < strings.size(); i++) {
            String string = strings.get(i);
            resultStrings.add(string.toUpperCase());
        }*/

        ArrayList<String> resultStrings = new ArrayList<>();

        // 1-выриант решения
//        for (int i = 0; i < strings.size(); i++){
//            String str = strings.get(i);
//            if (str.length()%2 == 0) resultStrings.add(str + " " + str);
//            else resultStrings.add(str + " " + str + " " + str);
//        }

        // 2-й вариант решения
//        for (int i = 0; i < strings.size(); i++){
//            String str = strings.get(i);
//            resultStrings.add( str.length()%2 == 0 ?  (str + " " + str) : (str + " " + str + " " + str));
//        }

        // 3-й вариант решения

        for (String str: strings){
            if (str.length()%2 == 0){
                resultStrings.add(String.join(" ", Collections.nCopies(2, str)));
            } else{
                resultStrings.add(String.join(" " , Collections.nCopies(3, str)));
            }

        }

        for (int i = 0; i < resultStrings.size(); i++) {
            System.out.println(resultStrings.get(i));
        }
    }
}
