package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public void fill(double numberOfLiters) throws Exception {
        if (numberOfLiters < 0)
            throw new Exception();
        fuel += numberOfLiters;
    }

    public double getWinterConsumption(int length) {
        return length * winterFuelConsumption + winterWarmingUp;
    }

    public double getSummerConsumption(int length) {
        return length * summerFuelConsumption;
    }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
        double consumption;
        if (!isSummer(date, SummerStart, SummerEnd)) {
            consumption = getWinterConsumption(length);
        } else {
            consumption = getSummerConsumption(length);
        }
        return consumption;
    }

    public int getNumberOfPassengersCanBeTransferred() {
        if (canPassengersBeTransferred()) {
            return numberOfPassengers;
        }
        return 0;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        fastenDriverBelt();
        if (numberOfPassengers > 0) {
            fastenPassengersBelts();
        }
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public abstract int getMaxSpeed();

    public static Car create(int type, int numberOfPassengers) {
        Car car;
        switch (type) {
            case Car.TRUCK:
                car = new Truck(numberOfPassengers);
                break;
            case Car.SEDAN:
                car = new Sedan(numberOfPassengers);
                break;
            case Car.CABRIOLET:
                car = new Cabriolet(numberOfPassengers);
                break;
            default:
                car = null;
                break;
        }
        return car;
    }

    public boolean isSummer(Date date, Date summerStart, Date summerEnd) {
        if (date.after(summerStart) && date.before(summerEnd)) {
            return true;
        }
        return false;
    }

    private boolean canPassengersBeTransferred() {
        if (isDriverAvailable() && fuel > 0) {
            return true;
        }
        return false;
    }
}