package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

////у каждого планшета будет свой объект менеджера,
//// который будет подбирать оптимальный набор роликов и их последовательность для каждого заказа
////Он также будет взаимодействовать с плеером и отображать ролики.
public class AdvertisementManager {

    private int timeSeconds;

    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        List<Advertisement> availableVideos = storage.list();
        List<Advertisement> showVideos = new ArrayList<>();
        int totalTime = 0;
        for (Advertisement video : availableVideos) {
            if (video.getDuration() < timeSeconds) {
                if ((totalTime + video.getDuration()) < timeSeconds) {
                    totalTime = totalTime + video.getDuration();
                    showVideos.add(video);
                } else
                    totalTime = totalTime;
            }
        }


        Collections.sort(availableVideos, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                long pricePerVideoDiff = o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying();
                if (pricePerVideoDiff != 0) {
                    return (int) pricePerVideoDiff;
                } else {
                    return (int) (o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration() - o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration());
                }
            }
        });
        totalTime = timeSeconds;

        StatisticManager.getInstance().register(new VideoSelectedEventDataRow(
                availableVideos, availableVideos.size(), totalTime));

        for (Advertisement adVideo : availableVideos) {
            if (adVideo.getDuration() <= totalTime && adVideo.getHits() > 0) {

                ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d", adVideo.getName(),
                        adVideo.getAmountPerOneDisplaying(), adVideo.getAmountPerOneDisplaying() * 1000 / adVideo.getDuration()));
                adVideo.revalidate();
                totalTime -= adVideo.getDuration();
            }
        }

        if (availableVideos.isEmpty()) {
            throw new NoVideoAvailableException();
        }
    }
}