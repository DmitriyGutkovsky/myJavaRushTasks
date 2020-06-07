package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<>();

    public static void main(String[] args) {
        String fileName = args[0];
        List<String> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            while (reader.ready()) {
                list.add(reader.readLine());
            }

            for (int i = 0; i < list.size(); i++) {
                String[] line = list.get(i).trim().split(" ");
                StringBuilder sb = new StringBuilder();
                int day = 0;
                int month = 0;
                int year = 0;
                switch (line.length) {
                    case 4:
                        sb.append(line[0]);
                        day = Integer.parseInt(line[1]);
                        month = Integer.parseInt(line[2]);
                        year = Integer.parseInt(line[3]);
                        break;
                    case 5:
                        sb.append(line[0]).append(" ").append(line[1]);
                        day = Integer.parseInt(line[2]);
                        month = Integer.parseInt(line[3]);
                        year = Integer.parseInt(line[4]);
                        break;
                    case 6:
                        sb.append(line[0]).append(" ").append(line[1]).append(" ").append(line[2]);
                        day = Integer.parseInt(line[3]);
                        month = Integer.parseInt(line[4]);
                        year = Integer.parseInt(line[5]);
                        break;
                    default:
                        day = Integer.parseInt(line[line.length - 3]);
                        month = Integer.parseInt(line[line.length - 2]);
                        year = Integer.parseInt(line[line.length - 1]);
                        for (int j = 0; j < line.length - 3; j++) {
                            sb.append(line[i]).append(" ");
                        }
                }
                String name = sb.toString();
                Calendar date = new GregorianCalendar(year, month - 1, day);
                Date bd = date.getTime();
                PEOPLE.add(new Person(name, bd));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // print list for checking
        for (Person person : PEOPLE) {
            System.out.println(person.toString());
        }
    }
}
