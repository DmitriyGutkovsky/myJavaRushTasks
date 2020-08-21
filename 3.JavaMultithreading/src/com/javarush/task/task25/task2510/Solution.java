package com.javarush.task.task25.task2510;

/* 
Поживем - увидим
*/
public class Solution extends Thread  {

    public Solution() {
        setDefaultUncaughtExceptionHandler(new MyExceptionHandler());
    }

    public static void main(String[] args) {
    }

    private class MyExceptionHandler implements UncaughtExceptionHandler {

        /*
    1. Если это Error, то вывести в консоль "Нельзя дальше работать".
    2. Если это Exception, то вывести в консоль "Надо обработать".
    3. Если это Throwable, то вывести в консоль "Поживем - увидим".
        */
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            if (e instanceof Error){
                System.out.println("Нельзя дальше работать");
                return;
            }
            if (e instanceof Exception) {
                System.out.println("Надо обработать");
                return;
            }
            if (e instanceof Throwable) {
                System.out.println("Поживем - увидим");
            }
        }
    }
}
