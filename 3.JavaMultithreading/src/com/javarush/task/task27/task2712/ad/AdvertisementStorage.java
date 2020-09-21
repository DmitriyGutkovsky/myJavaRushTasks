package com.javarush.task.task27.task2712.ad;


//хранилище рекламных роликов.
public class AdvertisementStorage {
    private static AdvertisementStorage instance;

    private AdvertisementStorage() {
    }

    public static AdvertisementStorage getInstance() {
        if (instance == null) {
            instance = new AdvertisementStorage();
        }
        return instance;
    }
}
