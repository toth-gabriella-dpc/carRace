package com.dpc.carrace;

public class Weather {
    private static final int CHANCE_TO_RAIN = 30;
    private static boolean isRaining;

    public static int advance() {
        return (int) (Math.random() * 100);
    }

    public static boolean isRaining() {
        int randomValue = advance();
        return randomValue >= CHANCE_TO_RAIN;
    }
}
