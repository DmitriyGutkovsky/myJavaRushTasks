package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;

import java.util.*;

//С его помощью будем регистрировать события в хранилище
public class StatisticManager {

    private static StatisticManager instance;
    private StatisticStorage statisticStorage = new StatisticStorage();

    private StatisticManager() {
    }

    public static StatisticManager getInstance() {
        if (instance == null) {
            instance = new StatisticManager();
        }
        return instance;
    }

    public void register(EventDataRow data) {
    }

    private class StatisticStorage {

        Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        public StatisticStorage() {
            EventType[] values = EventType.values();
            for (EventType value : values) {
                storage.put(value, new ArrayList<>());
            }
        }
    }
}

