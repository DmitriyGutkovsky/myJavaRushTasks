package com.javarush.task;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class WrapperSystemIn {
    //    public static void main(String[] args) {
    // кладем данные в строку
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Lena").append("\n");
        sb.append("Dima").append("\n");
        sb.append("Olya").append("\n");
        String data = sb.toString();

        // Оборачиваем строку в класс ByteArrayInputStream
        ByteArrayInputStream is = new ByteArrayInputStream(data.getBytes());

        // подменяем in
        System.setIn(is);
    }

    public static void main(String[] args) {
        WrapperSystemIn wrapperSystemIn = new WrapperSystemIn();
        //вызываем обычный метод, который не знает про эти манипуляции
        readAndPrintLine();

    }

    private static void readAndPrintLine() {

        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader reader = new BufferedReader(isr)) {
            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
