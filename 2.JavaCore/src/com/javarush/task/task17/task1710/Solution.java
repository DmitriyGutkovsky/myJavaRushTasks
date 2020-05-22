package com.javarush.task.task17.task1710;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
                //-c name sex bd
                System.out.println("c");
                addPersonToList(args[1], args[2], args[3]);
                break;
            case ("-u"):
                //-u id name sex bd
                System.out.println("u");
                addPersonByIdToList(args[1], args[2], args[3], args[4]);
                break;
            case ("-d"):
                //-d id
                System.out.println("d");
                deletePerson(args[1]);
                break;
            case ("-i"):
                //-i id
                System.out.println("i");
                infoByPerson(args[1]);
                break;
            default:
                System.out.println("default");
        }
    }

    private static void addPersonToList(String name, String sexString, String bd) {
        // -c - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
        if (sexString.equals("м")) {
            Sex sex = Sex.MALE;
        } else if (sexString.equals("ж")) {
            Sex sex = Sex.FEMALE;
        }

    }

    private static void addPersonByIdToList(String id, String name, String sex, String bd) {
        // -u - обновляет данные человека с данным id
    }

    private static void deletePerson(String id) {
        // -d - производит логическое удаление человека с id, заменяет все его данные на null
    }

    private static void infoByPerson(String id) {
        // -i - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)
    }
}
