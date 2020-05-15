package com.javarush.task.task15.task1516;

/* 
Значения по умолчанию
*/

public class Solution {

        public int intVar;
        public double doubleVar;
        public Double DoubleVar;
        public boolean booleanVar;
        public Object ObjectVar;
        public Exception ExceptionVar;
        public String StringVar;

        public static Solution one = new Solution();

    public static void main(String[] args) {
        System.out.println(one.intVar + "\n" + one.doubleVar + "\n" + one.DoubleVar + "\n" + one.booleanVar + " \n" + one.ObjectVar + "\n"
                + one.ExceptionVar + "\n" + one.StringVar);
    }
}
