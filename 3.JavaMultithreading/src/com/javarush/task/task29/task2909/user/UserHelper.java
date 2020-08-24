package com.javarush.task.task29.task2909.user;

import java.util.concurrent.atomic.AtomicInteger;

public class UserHelper {
    private User userAnya = new User("Аня", "Смирнова", 10);
    private User userRoma = new User("Рома", "Виноградов", 30);

    private boolean isManAnya = false;
    private boolean isManRoma = true;

    public void printUsers() {
        userAnya.printInfo();
        userAnya.printAdditionalInfo();

        userRoma.printInfo();
        userRoma.printAdditionalInfo();
    }

    public int calculateAverageAge() {
        User userUra = new User("Юра", "Карп", 28);
        return (userAnya.getAge() + userRoma.getAge() + userUra.getAge()) / 3;
    }

    public int calculateRate(AtomicInteger base, int age, boolean hasWork, boolean hasHouse) {
        int base1 = base.get();
        base1 = base1 + age / 100;
        base1 = (int) ((int) base1 * (hasWork ? 1.1 : 0.9));
        base1 = ((int) (base1 * (hasHouse ? 1.1 : 0.9)));
        return base1;
    }

    public String getBossName(User user) {
        Work work = user.getWork();
        return work.getBoss();
    }
}