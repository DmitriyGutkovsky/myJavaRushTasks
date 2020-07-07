package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        List<String> tempList = new LinkedList<>();
        try {
            fileName = reader.readLine();
//            fileName = "D:\\Study\\Java\\JavaRush\\JavaRushTasks\\JavaRushTasks\\3.JavaMultithreading\\src\\com\\javarush\\task\\task22\\task2207\\test.txt";
            try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
                while (fileReader.ready()) {
                    String line = fileReader.readLine();
                    String[] splitLine = line.trim().split(" ");

                    // add all words from thr file into tempList
                    Collections.addAll(tempList, splitLine);
                }

                while (tempList.size() > 1) {
                    String firstElement = tempList.get(0);
                    tempList.remove(0);
                    StringBuilder sb1 = new StringBuilder(firstElement);
                    String secondElement = sb1.reverse().toString();
                    for (int i = 0; i < tempList.size(); i++) {
                        if (tempList.get(i).equals(secondElement)) {
                            result.add(new Pair(firstElement, secondElement));
                            tempList.remove(secondElement);
                            break;
                        }
                    }
                }

                for (Pair pair : result) {
                    System.out.println(pair);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
