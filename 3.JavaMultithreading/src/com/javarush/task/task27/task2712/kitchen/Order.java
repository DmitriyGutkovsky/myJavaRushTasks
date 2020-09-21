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
        sb.append("Your order: [");
        if (dishes == null) return "";
        else {
            for (int i = 0; i < dishes.size() - 1; i++) {
                sb.append(dishes.get(i)).append(", ");
            }
        }
        sb.append(dishes.get(dishes.size() - 1)).append("]").append(" of ").append(tablet.toString());
        return sb.toString();
    }

    // подсчет времени приготовления всего заказа
    public int getTotalCookingTime() {
        return dishes.stream().mapToInt(x -> x.getDuration()).sum();
    }

    public boolean isEmpty() {
        if (dishes.size() == 0) return true;
        return false;
    }
}
