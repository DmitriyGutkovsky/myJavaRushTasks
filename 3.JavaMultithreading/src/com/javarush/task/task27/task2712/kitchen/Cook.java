package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;

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
        StatisticManager.getInstance().register(new CookedOrderEventDataRow(o.toString(), name, ((Order) arg).getTotalCookingTime() * 60, ((Order) arg).getDishes()));
        setChanged();
        notifyObservers(arg);
    }
}
