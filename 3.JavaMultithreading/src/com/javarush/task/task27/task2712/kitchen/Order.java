package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (dishes == null) return "";
        else {
            for (int i = 0; i < dishes.size() - 1; i++) {
                sb.append(dishes.get(i)).append(", ");
            }
        }
        sb.append(dishes.get(dishes.size() - 1)).append(" of ").append(tablet.toString());
        return sb.toString();
    }
}
