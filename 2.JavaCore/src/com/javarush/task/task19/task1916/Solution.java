package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<>();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String file1 = reader.readLine();
            String file2 = reader.readLine();
//            String file1 = "D:\\Дима\\JavaRush\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1916\\file1.txt";
//            String file2 = "D:\\Дима\\JavaRush\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1916\\file2.txt";
            try (BufferedReader fileReader1 = new BufferedReader(new FileReader(file1));
                 BufferedReader fileReader2 = new BufferedReader(new FileReader(file2))) {
                List<String> listFile1 = new ArrayList<>();
                List<String> listFile2 = new ArrayList<>();
                while (fileReader1.ready()) {
                    listFile1.add(fileReader1.readLine());
                }

                while (fileReader2.ready()) {
                    listFile2.add(fileReader2.readLine());
                }

                while (!listFile1.isEmpty() | !listFile2.isEmpty()) {

                    if (listFile1.isEmpty()) {
                        lines.add(new LineItem(Type.ADDED, listFile2.get(0)));
                        listFile2.remove(0);
                    } else if (listFile2.isEmpty()) {
                        lines.add(new LineItem(Type.REMOVED, listFile1.get(0)));
                        listFile1.remove(0);
                    } else if (listFile1.get(0).equals(listFile2.get(0))) {
                        lines.add(new LineItem(Type.SAME, listFile1.get(0)));
                        listFile1.remove(0);
                        listFile2.remove(0);
                    } else if (listFile1.get(0).equals(listFile2.get(1))) {
                        lines.add(new LineItem(Type.ADDED, listFile2.get(0)));
                        listFile2.remove(0);
                    } else {
                        lines.add(new LineItem(Type.REMOVED, listFile1.get(0)));
                        listFile1.remove(0);
                    }
                }

//                checking block
                for (LineItem line : lines) {
                    System.out.println(line.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

        @Override
        public String toString() {
            return type + " " + line;
        }
    }
}
