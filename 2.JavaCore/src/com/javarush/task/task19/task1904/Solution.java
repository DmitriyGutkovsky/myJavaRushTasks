package com.javarush.task.task19.task1904;

/* 
И еще один адаптер
*/

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String readData = fileScanner.nextLine();

            String[] data = readData.split(" ");

            String lastName = data[0];
            String middleName = data[2];
            String firstName = data[1];
            int year = Integer.parseInt(data[5]);
            int month = Integer.parseInt(data[4]) - 1;
            int day = Integer.parseInt(data[3]);
            Calendar calendar = new GregorianCalendar(year, month, day);
            Date bd = calendar.getTime();

            return new Person(firstName, middleName, lastName, bd);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
