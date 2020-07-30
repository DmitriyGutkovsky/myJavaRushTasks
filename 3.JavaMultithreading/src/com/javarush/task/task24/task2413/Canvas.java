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

    void setPoint(double x, double y, char c){
        int roundX = Math.round((float) x);
        int roundY = Math.round((float)y);
        if(roundX<0 || roundY < 0 || roundY >= matrix.length || roundX >= matrix.length){
            return;
        } else {
            matrix[roundY][roundX] = c;
        }
    }

    void drawMatrix(double x, double y, int[][] matrix, char c){

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    setPoint(x+j, y+i, c);
                }
            }
        }

    }

    void clear(){
        matrix = new char[this.height +2][this.width+2];
    }

    void print(){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
