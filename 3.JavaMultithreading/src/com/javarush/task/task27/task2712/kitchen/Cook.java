package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;

public class Cook extends Observable {
    private final String name;
    private boolean busy;

    public Cook(String name) {
        this.name = name;
    }

    public boolean isBusy() {
        return busy;
    }

    //    - observable - объект, который отправил нам значение
    //- arg - само значение, в нашем случае - это объект Order
//    @Override
//    public void update(Observable o, Object arg) {
//        ConsoleHelper.writeMessage(arg.toString());
//        ConsoleHelper.writeMessage("Start cooking - " + arg.toString() +
//                ", cooking time " + ((Order) arg).getTotalCookingTime() + "min");
//        StatisticManager.getInstance().register(new CookedOrderEventDataRow(o.toString(), name, ((Order) arg).getTotalCookingTime() * 60, ((Order) arg).getDishes()));
//        setChanged();
//        notifyObservers(arg);
//    }
    public void startCookingOrder(Order order){
        busy = true;
        ConsoleHelper.writeMessage("Start cooking - " + order);
        setChanged();
        notifyObservers(order);
        CookedOrderEventDataRow row = new CookedOrderEventDataRow(order.getTablet().toString(), name, order.getTotalCookingTime() * 60, order.getDishes());
        StatisticManager.getInstance().register(row);
        try {
            Thread.sleep(order.getTotalCookingTime()*10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        busy = false;
    }

    @Override
    public String toString() {
        return name;
    }
}
