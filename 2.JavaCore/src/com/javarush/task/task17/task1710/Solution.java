package com.javarush.task.task17.task1710;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        switch (args[0]){
            case ("-c"):
                System.out.println("c");
                break;
            case ("-u"):
                System.out.println("u");
                break;
            case ("-d"):
                System.out.println("d");
                break;
            case ("-i"):
                System.out.println("i");
                break;
            default:
                System.out.println("default");
        }
    }
}
