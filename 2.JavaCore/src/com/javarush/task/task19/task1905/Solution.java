package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

        // code below added for checking
        Customer customer = new Customer() {
            @Override
            public String getCompanyName() {
                return null;
            }

            @Override
            public String getCountryName() {
                return null;
            }
        };

        Contact contact = new Contact() {
            @Override
            public String getName() {
                return null;
            }

            @Override
            public String getPhoneNumber() {
                return "+38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567";
            }
        };

        DataAdapter dataAdapter = new DataAdapter(customer, contact);
        String dialString = dataAdapter.getDialString();
        System.out.println(dialString);

    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            Iterator<Map.Entry<String, String>> iterator = countries.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> pair = iterator.next();
                String key = pair.getKey();
                String value = pair.getValue();
                if (value.equals(customer.getCountryName())) return key;
            }
            return null;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String[] splitName = contact.getName().split(", ");
            return splitName[1];
        }

        @Override
        public String getContactLastName() {
            String[] splitName = contact.getName().split(", ");
            return splitName[0];
        }

        @Override
        public String getDialString() {
            String contactPhoneNumber = contact.getPhoneNumber();
            String[] splitedContactPhoneNumber = contactPhoneNumber.split(" or ");
            String[] phoneNumbers = new String[splitedContactPhoneNumber.length];
            for (int i = 0; i < splitedContactPhoneNumber.length; i++) {
                phoneNumbers[i] = splitedContactPhoneNumber[i].replace("+", "").replace("(", "")
                        .replace(")", "").replace("-", "");
            }
            return "callto://+" + phoneNumbers[0];
        }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}