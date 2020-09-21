package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable implements Observer {
    private String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    //    - observable - объект, который отправил нам значение
    //- arg - само значение, в нашем случае - это объект Order
    @Override
    public void update(Observable o, Object arg) {
            ConsoleHelper.writeMessage(arg.toString());
            ConsoleHelper.writeMessage("Start cooking - " + arg.toString() +
                    ", cooking time " + ((Order) arg).getTotalCookingTime() + "min");
            setChanged();
            notifyObservers(arg);
    }
}
