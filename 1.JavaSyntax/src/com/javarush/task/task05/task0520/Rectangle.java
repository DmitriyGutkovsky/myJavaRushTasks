package com.javarush.task.task05.task0520;

/* 
Создать класс прямоугольник (Rectangle)
*/


public class Rectangle {
    //напишите тут ваш код
    int top, left, width, height;

    public Rectangle(int top, int left, int width, int height){
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
    }

    public Rectangle(int top, int left, int width){
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = 1;
    }

    public Rectangle(int top, int left){
        this.top = top;
        this.left = left;
        this.width = 1;
        this.height = 1;
    }

    public Rectangle(int top){
        this.top = top;
        this.left = 1;
        this.width = 1;
        this.height = 1;
    }



    public static void main(String[] args) {

    }
}
