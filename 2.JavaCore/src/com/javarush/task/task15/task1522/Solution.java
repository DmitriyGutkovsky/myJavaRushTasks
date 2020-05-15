package com.javarush.task.task15.task1522;

/* 
Закрепляем паттерн Singleton
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    static {
        readKeyFromConsoleAndInitPlanet();
    }

    public static void main(String[] args) {
        System.out.println(thePlanet);

    }

    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут


    public static void readKeyFromConsoleAndInitPlanet() {
        // implement step #5 here - реализуйте задание №5 тут

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String readedPlanet = reader.readLine();

            if ( readedPlanet.equals(Planet.SUN)) { thePlanet = Sun.getInstance();}
                else  if (readedPlanet.equals(Planet.MOON)) { thePlanet = Moon.getInstance();}
                    else if (readedPlanet.equals(Planet.EARTH)) { thePlanet = Earth.getInstance();}
                        else thePlanet = null;



            }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

}
