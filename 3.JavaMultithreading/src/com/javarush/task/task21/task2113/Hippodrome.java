package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    static Hippodrome game;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    void run() {
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

    void move() {
        for (Horse hors : horses) {
            hors.move();
        }
    }

    void print() {
        for (Horse hors : horses) {
            hors.print();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        double max = Double.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < horses.size(); i++) {
            if (horses.get(i).distance > max) {
                max = horses.get(i).distance;
                index = i;
            }
        }
        return horses.get(index);
    }

    public void printWinner() {
        System.out.printf("Winner is %s!\n", getWinner().name);
    }

    public static void main(String[] args) {
        game = new Hippodrome(new ArrayList<>());

        Horse horse1 = new Horse("One", 3, 0);
        Horse horse2 = new Horse("Two", 3, 0);
        Horse horse3 = new Horse("Three", 3, 0);

        game.horses.add(horse1);
        game.horses.add(horse2);
        game.horses.add(horse3);

        game.run();

        game.printWinner();
    }
}
