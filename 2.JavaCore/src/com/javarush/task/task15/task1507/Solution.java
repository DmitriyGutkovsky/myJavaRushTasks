package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }
    //1
    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }
    //2
    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }
    //3
    public static void printMatrix (Integer m, Integer n, String value){
        System.out.println(value);
    }
    //4
    public static void printMatrix (int m, Integer n, String value){
        System.out.println(value);
    }
    //5
    public static void printMatrix (Integer m, int n, String value){
        System.out.println(value);
    }
    //6
    public static void printMatrix (Integer m, int n, Object value){
        System.out.println(value);
    }
    //7
    public static void printMatrix (Integer m, Integer n, Object value){
        System.out.println(value);
    }
    //8
    public static void printMatrix (int m, Integer n, Object value){
        System.out.println(value);
    }
    //9
    public static void printMatrix ( boolean m, Integer n, Object value){
        System.out.println(value);
    }
    //10
    public static void printMatrix ( boolean m, boolean n, Object value){
        System.out.println(value);
    }

}
