package com.javarush.task.task14.task1419;

import com.javarush.task.task14.task1411.Person;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        //1
        try {
            float i = 1 / 0;
        } catch (Exception e) {
            exceptions.add(e);
        }
        //напишите тут ваш код
        //2
        try {
            int[] array = {1, 2, 3};
            System.out.println(array[4]);
        } catch (ArrayIndexOutOfBoundsException e){
            exceptions.add(e);
        }
        //3
        try {
            ArrayList<String> arrayList = new ArrayList();
            System.out.println(arrayList.get(2));
        } catch (IndexOutOfBoundsException e){
            exceptions.add(e);
        }
        //4
        try{
            method1();
        } catch (FileNotFoundException e){
            exceptions.add(e);
        }
        //5
        try {
            int a = Integer.parseInt(null);
        } catch (NumberFormatException e){
            exceptions.add(e);
        }
        //6 Если попытаться записать в ячейку массива ссылку на объект неправильного типа, возникнет исключение ArrayStoreException.
        try{

            Object[] s1 = new String[3];
            s1[0] = new Integer(2);

        } catch (Exception e){
            exceptions.add(e);
        }
        //7
        //В языке программирования Java вы не можете выполнять явное преобразование типов произвольным образом.
        //Если выполнить такое преобразование для классов, не связанных "узами" наследования, или другим недопустимым способом,
        //возникнет исключение ClassCastException.
        try{
            Object a = new Character('1');
            System.out.println((Byte)a);
        } catch (ClassCastException e){
            exceptions.add(e);
        }
        //8
        //Исключение возникает при попытке создать массив отрицательного размера
        try{
            int[] a = new int [-10];
        } catch (NegativeArraySizeException e){
            exceptions.add(e);
        }
        //9
        // Если попытаться использовать в программе ссылку, содержащую значение null, возникнет исключение NullPointerException
        try{

            int [] array = new int [3];
            array = null;
            System.out.println(array.length);
        } catch (NullPointerException e){
            exceptions.add(e);
        }

        //10
        // В Java есть методы, позволяющие работать с отдельными символами строк класса String.
        //Например, метод charAt позволяет извлечь символ, расположенный в заданной позиции.
        //Если указать позицию, лежащую за границей строки, возникнет исключение StringIndexOutOfBoundsException.

        try {
            String line = "home";
            System.out.println(line.charAt(6));
        } catch (StringIndexOutOfBoundsException e){
            exceptions.add(e);
        }


    }

    private static void method1() throws FileNotFoundException {

        FileInputStream f = new FileInputStream("C:\\text.txt");
    }

}
