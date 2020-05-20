package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreadFive extends Thread {
    private static int count = 0;

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (; ; ) {
            try {
                String line = reader.readLine();
                if (line.equals("N")) break;
                count += Integer.parseInt(line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(count);

    }
}
