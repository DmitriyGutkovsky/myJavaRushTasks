package com.javarush.task.task24.task2413;

public class Canvas {
    private int width;
    private  int height;
    private char[][] matrix;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }

    public Canvas(int width, int heigth) {
        this.width = width;
        this.height = heigth;
        matrix = new char[this.height +2][this.width+2];
    }
}
