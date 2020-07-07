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
            try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))){
                while (fileReader.ready()){
                    String line = fileReader.readLine();
                    String[] splitLine = line.trim().split(" ");

                    // add all words from thr file into tempList
                    for (int i = 0; i < splitLine.length; i++) {
                        tempList.add(splitLine[i]);
                    }
                }

                Set<Pair> set = new LinkedHashSet<>();

                for (int i = 0; i < tempList.size()-1; i++) {
                    StringBuilder sb1 = new StringBuilder(tempList.get(i));
                    StringBuilder reverse = sb1.reverse();
                    for (int j = 1; j < tempList.size(); j++) {
                        StringBuilder sb2 = new StringBuilder(tempList.get(j));
                            if (reverse.toString().equals(sb2.toString())) {
                            set.add(new Pair(sb1.toString(), sb2.toString()));
                        }
                    }
                }

                result.addAll(set);

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
