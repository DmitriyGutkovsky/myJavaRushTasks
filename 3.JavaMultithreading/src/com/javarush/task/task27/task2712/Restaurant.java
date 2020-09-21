package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;

public class Restaurant {
    public static void main(String[] args) {
        Tablet tablet1 = new Tablet(1);

        Cook cook = new Cook("Dima");
        tablet1.addObserver(cook);
        for (int i = 1; i < 2; i++) {
            tablet1.createOrder();
        }
    }
}
