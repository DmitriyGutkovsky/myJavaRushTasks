package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;

import java.util.Observable;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable {
    private final int number; //это номер планшета, чтобы можно было однозначно установить, откуда поступил заказ
    private static Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }

    //будет создавать заказ из тех блюд, которые выберет пользователь.
    public Order createOrder() {
        Order order = null;
        try {
            order = new Order(this);
            AdvertisementManager advertisementManager = new AdvertisementManager(order.getTotalCookingTime() * 60);
            try {
                advertisementManager.processVideos();
            } catch (NoVideoAvailableException e){
//                logger.log(Level.INFO, "No video is available for the order " + order);
                logger.info("No video is available for the order " + order);
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
        setChanged();
        if (!order.isEmpty()) {
            notifyObservers(order);
        }
        return order;
    }

    @Override
    public String toString() {
        return "Tablet{number=" + number + "}";
    }


}
