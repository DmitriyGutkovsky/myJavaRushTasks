package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

public class Restaurant {
    public static void main(String[] args) {
        Tablet tablet1 = new Tablet(1);

        Cook cook = new Cook("Dima");
        Waiter waiter = new Waiter();
        tablet1.addObserver(cook);
        cook.addObserver(waiter);
        for (int i = 1; i < 2; i++) {
            tablet1.createOrder();
        }
    }
}