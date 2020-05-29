package com.javarush.task;

import java.io.FileInputStream;
import java.io.IOException;

class MainTestFileInputStream {
    public static void main(String[] args) throws IOException {
        // D:\Дима\JavaRush\JavaRushTasks\JavaRushTasks\2.JavaCore\src\com\javarush\task\test.txt
        FileInputStream fileInputStream = new FileInputStream("D:\\Дима\\JavaRush\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\test.txt");
        int i;
        while ((i = fileInputStream.read()) != -1){
            System.out.print((char)i);

        }
    }
}
