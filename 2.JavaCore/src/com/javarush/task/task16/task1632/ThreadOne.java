package com.javarush.task.task16.task1632;

public class ThreadOne extends Thread {
    private int count = 0;

    @Override
    public void run() {
        while (true) {
            count++;
        }
    }
}
