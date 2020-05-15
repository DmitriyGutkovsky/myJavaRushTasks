package com.javarush.task.task15.task1525;

import jdk.jfr.events.FileReadEvent;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();


    static {
        FileReader fr = null;
        try {
            fr = new FileReader(Statics.FILE_NAME);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner sc = new Scanner(fr);
        while (sc.hasNext()) {
            lines.add(sc.nextLine());
        }
    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
