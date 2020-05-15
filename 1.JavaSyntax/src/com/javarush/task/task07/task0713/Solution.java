package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> mainList = new ArrayList<>();
        ArrayList<Integer> listDiv3 = new ArrayList<>();
        ArrayList<Integer> listDiv2 = new ArrayList<>();
        ArrayList<Integer> listLast = new ArrayList<>();

        for (int i = 0; i < 20; i++){
            mainList.add(Integer.parseInt(reader.readLine()));
        }

        for (int i = 0; i < mainList.size(); i++){
            if (mainList.get(i) % 3 == 0 ) listDiv3.add(mainList.get(i));
            if (mainList.get(i) % 2 == 0 ) listDiv2.add(mainList.get(i));
            if ((mainList.get(i) % 3 != 0) && (mainList.get(i) % 2 != 0)) listLast.add(mainList.get(i));
        }

        printList(listDiv3);
        printList(listDiv2);
        printList(listLast);
    }

    public static void printList(ArrayList<Integer> list) {
        //напишите тут ваш код
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
//        System.out.println();
    }
}
