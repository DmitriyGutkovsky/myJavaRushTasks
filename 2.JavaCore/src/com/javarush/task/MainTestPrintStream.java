package com.javarush.task;

import java.io.FileNotFoundException;
import java.io.PrintStream;

class MainTestPrintStream {
    public static void main(String[] args) throws FileNotFoundException {
        // D:\Дима\JavaRush\JavaRushTasks\JavaRushTasks\2.JavaCore\src\com\javarush\task\test.txt

        PrintStream printStream = new PrintStream("D:\\Дима\\JavaRush\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\test.txt");

        printStream.println(222);
        printStream.println("Hello");
        printStream.println(false);
    }
}
