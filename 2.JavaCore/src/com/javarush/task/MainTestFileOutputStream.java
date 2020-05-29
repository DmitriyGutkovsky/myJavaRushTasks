package com.javarush.task;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

class MainTestFileOutputStream {
    public static void main(String[] args) throws IOException {
        // D:\Дима\JavaRush\JavaRushTasks\JavaRushTasks\2.JavaCore\src\com\javarush\task\test.txt
        File file = new File("D:\\Дима\\JavaRush\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\test.txt");
        String text = "Привет! Добро пожаловать на JavaRush - лучший сайт для тех, кто хочет стать программистом!";
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
//        FileOutputStream fileOutputStream = new FileOutputStream(file);
        String newText = "\nDima\n";
        fileOutputStream.write(text.getBytes());
        fileOutputStream.write(newText.getBytes());
        fileOutputStream.close();
    }
}
