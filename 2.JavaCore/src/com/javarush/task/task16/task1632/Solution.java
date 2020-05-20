package com.javarush.task.task16.task1632;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        ThreadOne threadOne = new ThreadOne();
        ThreadTwo threadTwo = new ThreadTwo();
        ThreadThree threadThree = new ThreadThree();
        ThreadFour threadFour = new ThreadFour();
        ThreadFive threadFive = new ThreadFive();

        threads.add(threadOne);
        threads.add(threadTwo);
        threads.add(threadThree);
        threads.add(threadFour);
        threads.add(threadFive);

    }

    public static void main(String[] args) {
        for (Thread thread : threads) {
            thread.start();
        }

    }
}