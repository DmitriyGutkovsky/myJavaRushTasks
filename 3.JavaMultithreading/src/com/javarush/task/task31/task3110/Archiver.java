package com.javarush.task.task31.task3110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите полный путь архива");
        try {
            String pathToArchive = reader.readLine();
            ZipFileManager zipFileManager = new ZipFileManager(Paths.get(pathToArchive));
            System.out.println("Введите путь к файлу, который будем архивировать");
            String pathToFile = reader.readLine();
            zipFileManager.createZip(Paths.get(pathToFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
