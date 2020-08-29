package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {
    private ConcurrentHashMap<String, String> map;
    private AtomicInteger i = new AtomicInteger(1);

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        while (!thread.isInterrupted()) {
            try {
                map.put(i.toString(), "Some text for " + i);
                i.incrementAndGet();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(thread.getName() + " thread was terminated");
                break;
            }
        }

    }
}
