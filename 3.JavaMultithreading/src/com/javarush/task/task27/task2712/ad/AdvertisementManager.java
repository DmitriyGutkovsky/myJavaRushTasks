package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;

//у каждого планшета будет свой объект менеджера,
// который будет подбирать оптимальный набор роликов и их последовательность для каждого заказа
//Он также будет взаимодействовать с плеером и отображать ролики.
public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        if (storage.list().size() == 0) {
            throw new NoVideoAvailableException();
        }
    }
}
