package com.javarush.task.task30.task3006;

public class Pair {
    private int x;
    private int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("x=%d, y=%d", x, y);
    }

    public void swap() {
        x ^= y;
        y ^= x;
        x ^= y;
    }

    //Первое выражение определяет исключающую маску - общее значение, состоящее из уникальных (неповторяемых) битов.
    //
    //1. a = 0000 1010 ^ 0000 1001 = 0000 0011
    //
    //Второе выражение маскирует биты b, позволяя выделить биты a.
    //
    //2. b = 0000 1001 ^ 0000 0011 = 0000 1010
    //
    //Третье выражение маскирует биты a, позволяя выделить биты b.
    //
    //3. a = 0000 0011 ^ 0000 1010 = 0000 1001
}
