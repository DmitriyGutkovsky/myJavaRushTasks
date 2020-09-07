package com.javarush.task.task31.task3110;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleHelper {
    private static Scanner sc = new Scanner(System.in);

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return sc.nextLine();
    }

    public static int readInt() throws IOException {
        return sc.nextInt();
    }
}
