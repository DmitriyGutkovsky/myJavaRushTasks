package com.javarush.task.task16.task1632;

public class ThreadFour extends Thread implements Message {
    private volatile boolean stop = false;

    @Override
    public void run() {
        while (!stop) {
        }
    }

    @Override
    public void showWarning() {
        stop = true;
    }
}
