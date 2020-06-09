package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String fileName = reader.readLine();
//            String fileName = "D:\\Дима\\JavaRush\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1918\\file.html";

            try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {

                StringBuilder sb = new StringBuilder();

                while (fileReader.ready()){
                    sb.append(fileReader.readLine());
                }

                Document document = Jsoup.parse(sb.toString(), "", Parser.xmlParser());
                Elements elem = document.select(args[0]);
                for (Element elements : elem){
                    System.out.println(elements);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
