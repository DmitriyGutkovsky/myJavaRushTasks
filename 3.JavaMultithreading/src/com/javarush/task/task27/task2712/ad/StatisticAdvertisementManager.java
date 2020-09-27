package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class StatisticAdvertisementManager {
    private static StatisticAdvertisementManager ourInstance;
    private AdvertisementStorage storage = AdvertisementStorage.getInstance();


    public static StatisticAdvertisementManager getOurInstance() {
        if (ourInstance == null) {
            ourInstance = new StatisticAdvertisementManager();
        }
        return ourInstance;
    }

    private StatisticAdvertisementManager() {
    }
    
    public List<Advertisement>getVideoSet (boolean isActive) {
        List<Advertisement> result = new ArrayList<>();
        for (Advertisement advertisement : storage.list()) {
            if (!isActive ^ advertisement.isActive()){
                result.add(advertisement);
            }
        }
        return result;
    } 
}
