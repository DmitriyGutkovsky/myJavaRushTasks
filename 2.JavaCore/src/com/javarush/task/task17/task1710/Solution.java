package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
        switch (args[0]) {
            case ("-c"):
                //-c name sex bd
                addPersonToList(args[1], args[2], args[3]);
                break;
            case ("-u"):
                //-u id name sex bd
                addPersonByIdToList(args[1], args[2], args[3], args[4]);
                break;
            case ("-d"):
                //-d id
                deletePerson(args[1]);
                break;
            case ("-i"):
                //-i id
                infoByPerson(args[1]);
                break;
            default:
                System.out.println("default");
        }
    }

    private static void addPersonToList(String name, String sexString, String bd) {
        // -c - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
        //bd - дата рождения в следующем формате 15/04/1990
        // parsing person's date of birthday
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date d = null;
        try {
            d = dateFormat.parse(bd);
        } catch (ParseException e) {
            System.out.println(e);
        }

        // parsing person's sex and  adding person to allPeopple list
        if (sexString.equals("м")) {
            Person person = Person.createMale(name, d);
            allPeople.add(person);
            System.out.println(allPeople.indexOf(person));
        } else if (sexString.equals("ж")) {
            Person person = Person.createFemale(name, d);
            allPeople.add(person);
            System.out.println(allPeople.indexOf(person));
        }
    }

    private static void addPersonByIdToList(String id, String name, String sexString, String bd) {
        // -u - обновляет данные человека с данным id
        // parsing person's date of birthday
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date d = null;
        try {
            d = dateFormat.parse(bd);
        } catch (ParseException e) {
            System.out.println(e);
        }

        int index = 0;
        try{
            index = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }

        // parsing person's sex and  adding person to allPeopple list
        if (sexString.equals("м")) {
            Person person = Person.createMale(name, d);
            allPeople.remove(index);
            allPeople.add(index, person);
        } else if (sexString.equals("ж")) {
            Person person = Person.createFemale(name, d);
            allPeople.remove(index);
            allPeople.add(index, person);
        }
    }

    private static void deletePerson(String id) {
        // -d - производит логическое удаление человека с id, заменяет все его данные на null
        int index = 0;
        try{
            index = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }

        Person person = allPeople.get(index);
        person.setName(null);
        person.setBirthDate(null);
        person.setSex(null);

        allPeople.remove(index);
        allPeople.add(index, person);
    }

    private static void infoByPerson(String id) {
        // -i - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990).
        int index = 0;
        try{
            index = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        Person person = allPeople.get(index);
        String  printSex = null;
        Sex sex = person.getSex();
        if (sex.equals(Sex.MALE)) {
            printSex = "м";
        } else printSex = "ж";

        SimpleDateFormat newDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        String newBD;
        newBD = newDateFormat.format(person.getBirthDate());

        System.out.println(person.getName() + " " + printSex + " " + newBD);





    }
}
