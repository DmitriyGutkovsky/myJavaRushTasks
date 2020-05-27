package com.javarush.task;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainTest {
    public static void main(String[] args) {
        //D:\gutkovsky\lectures\Вебинары.docx
        //D:\gutkovsky\lectures\temp.docx

        long sum = 0;

        try (FileInputStream fileInputStream = new FileInputStream("D:\\gutkovsky\\lectures\\Вебинары.docx")){

            FileOutputStream fileOutputStream = new FileOutputStream("D:\\gutkovsky\\lectures\\temp.docx");

            while (fileInputStream.available() > 0) {
                int data = fileInputStream.read();
                fileOutputStream.write(data);
                sum += data;
            }
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sum);
    }
}
