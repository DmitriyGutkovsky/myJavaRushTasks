package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //для вывода message в консоль
    public static void writeMessage(String message) {
        System.out.println(message);
    }

    // для чтения строки с консоли
    public static String readString() throws IOException {
        return reader.readLine();
    }

    //просит пользователя выбрать блюдо и добавляет его в список.
    public static List<Dish> getAllDishesForOrder() throws IOException {
        writeMessage(Dish.allDishesToString());
        writeMessage("Введите, пожалуйста, название выбранного блюда.\n" +
                "После окончания выбора введите exit");
        List<Dish> selectedDish = new ArrayList<>(16);
        boolean dishExists;
        Dish dish = null;
        while (true) {
            String line = readString();
            if (line.toLowerCase().equals("exit")) {
                break;
            }
            try {
                dish = Dish.valueOf(line);
                dishExists = true;
            } catch (IllegalArgumentException e) {
                dishExists = false;
                writeMessage("Такого блюда нет");
            }
            if (dishExists) {
                selectedDish.add(dish);
            }
        }
        return selectedDish;
    }
}
