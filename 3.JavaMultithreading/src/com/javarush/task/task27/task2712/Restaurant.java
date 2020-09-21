package com.javarush.task.task27.task2712;

public class Restaurant {
    public static void main(String[] args) {
        Tablet tablet1 = new Tablet(1);
        for (int i = 1; i < 5; i++) {
            tablet1.createOrder();
        }
    }
}
