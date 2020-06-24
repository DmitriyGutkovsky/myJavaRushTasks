package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses = new ArrayList<>();
    static Hippodrome game;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    void run(){
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    void move(){
    }

    void print(){
    }

    public static void main(String[] args) {
        game = new Hippodrome(new ArrayList<>());

        Horse horse1 = new Horse("One", 3, 0);
        Horse horse2 = new Horse("One", 3, 0);
        Horse horse3 = new Horse("One", 3, 0);

        game.horses.add(horse1);
        game.horses.add(horse2);
        game.horses.add(horse3);




    }
}
