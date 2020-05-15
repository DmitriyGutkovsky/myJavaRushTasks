package com.javarush.task.task15.task1529;

public class Plane implements CanFly {
    int number;

    @Override
    public void fly() {
        System.out.println("Plane is flying");
    }

    public Plane(int number) {
        this.number = number;
    }
}
