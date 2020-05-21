package com.javarush.task.task17.task1707;


public class IMF {

    private static volatile IMF imf;

    public static IMF getFund() {
        //add your code here - добавь код тут
        IMF localImf = imf;
        if (localImf == null){
            synchronized (IMF.class){
                localImf = imf;
                if (localImf == null){
                    imf = new IMF();
                    localImf = imf;
                }
            }
        }
        return localImf;
    }

    private IMF() {
    }
}
