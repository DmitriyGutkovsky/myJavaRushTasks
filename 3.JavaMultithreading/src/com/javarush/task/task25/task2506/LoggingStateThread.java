package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private Thread target;

    public LoggingStateThread(Thread target) {
        this.target = target;
    }

    @Override
    public void run() {
        State state = target.getState();
        System.out.println(state);
        while (true) {
            State state2 = target.getState();
            if (state != state2) {
                System.out.println(state2);
                state = state2;
                if (state == State.TERMINATED) {
                    break;
                }
            }
        }

    }
}
