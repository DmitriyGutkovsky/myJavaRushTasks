package com.javarush.task.task24.task2413;


public abstract class BaseObject {
    protected double x;
    protected double y;
    protected double radius;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    abstract void draw(Canvas canvas);

    abstract void move();

    boolean isIntersec(BaseObject o){

        double distance = Math.sqrt(Math.pow((x-o.x),2) + Math.pow((y-o.y),2));

        if(distance<=Math.max(this.radius, o.radius)) return true;

        return false;
    }
}
