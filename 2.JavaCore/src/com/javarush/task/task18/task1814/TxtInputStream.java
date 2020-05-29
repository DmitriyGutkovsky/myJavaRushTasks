package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {

    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(fileName);
        if (!fileName.endsWith(".txt")) {
//        if (!fileName.endsWith(".txt") || !fileName.endsWith(".TXT")){ //  с двумя условиями не проходит проверку
            super.close();
            throw new UnsupportedFileNameException();
        }
    }

    public static void main(String[] args) throws IOException, UnsupportedFileNameException {
        Scanner sc = new Scanner(System.in);
        String file = sc.nextLine();
        // D:\Дима\JavaRush\JavaRushTasks\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1814\test2.txt
        //D:\Дима\JavaRush\JavaRushTasks\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1814\test.docx
        TxtInputStream txtInputStream = new TxtInputStream(file);
    }
}

