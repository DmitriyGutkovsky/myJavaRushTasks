package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
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
        List<Advertisement> advertisements1 = new ArrayList<>();
        for (Advertisement advertisement : storage.list()) {
            if (advertisement.getHits() > 0) {
                advertisements1.add(advertisement);
            }

        }
        List<Advertisement> advertisements2 = new ArrayList<>();
        chooseAdvertisement(advertisements1, advertisements2, timeSeconds);

        int timeLeft = timeSeconds;
        for (Advertisement advertisement : advertisements2) {
            if (timeLeft < advertisement.getDuration()) {
                continue;
            }

            ConsoleHelper.writeMessage(advertisement.getName() + " is displaying... "
                    + advertisement.getAmountPerOneDisplaying() + ", "
                    + advertisement.getAmountPerOneDisplaying() * 1000 / advertisement.getDuration());

            timeLeft -= advertisement.getDuration();
            advertisement.revalidate();
        }

        if (timeLeft == timeSeconds) {
            throw new NoVideoAvailableException();
        }
    }

    private void chooseAdvertisement(List<Advertisement> begin, List<Advertisement> end, int time) {
        if (begin.isEmpty()) {
            return;
        }
        Advertisement chooseAdvertisement;
        Advertisement advertisementAmount = Collections.max(begin, Comparator.comparing(Advertisement::getAmountPerOneDisplaying));
        List<Advertisement> advertisementsAmount = begin.stream()
                .filter(advertisement -> advertisement.getAmountPerOneDisplaying() == advertisementAmount.getAmountPerOneDisplaying())
                .collect(Collectors.toList());
        if (advertisementsAmount.size() > 1) {
            Advertisement advertisementDuration = Collections.max(advertisementsAmount, Comparator.comparing(Advertisement::getDuration));
            List<Advertisement> advertisementsDuration = advertisementsAmount.stream()
                    .filter(advertisement -> advertisement.getDuration() == advertisementDuration.getDuration())
                    .collect(Collectors.toList());
            if (advertisementsDuration.size() > 1) {
                chooseAdvertisement = Collections.max(advertisementsDuration, Comparator.comparing(Advertisement::getHits));
            } else {
                chooseAdvertisement = advertisementDuration;
            }
        } else {
            chooseAdvertisement = advertisementAmount;
        }
        begin.remove(chooseAdvertisement);
        if (time >= chooseAdvertisement.getDuration()) {
            end.add(chooseAdvertisement);
            time -= chooseAdvertisement.getDuration();
        }
        chooseAdvertisement(begin, end, time);
    }
}