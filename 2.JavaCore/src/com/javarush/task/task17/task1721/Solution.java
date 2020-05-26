package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<>();
    public static List<String> forRemoveLines = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String firstFile = sc.nextLine();
        String secondFile = sc.nextLine();

        try (BufferedReader firstFileReader = new BufferedReader(new FileReader(new File(firstFile)))) {
            while (firstFileReader.ready()) {
                allLines.add(firstFileReader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader secondFileReader = new BufferedReader(new FileReader(new File(secondFile)))) {
            while (secondFileReader.ready()) {
                forRemoveLines.add(secondFileReader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            new Solution().joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }

    }

    public void joinData() throws CorruptedDataException {

        boolean contains = false;

        if (allLines.containsAll(forRemoveLines)) contains = true;

        if (contains) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }


    }
}
