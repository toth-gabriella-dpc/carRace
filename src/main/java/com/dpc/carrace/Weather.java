package com.dpc.carrace;

import com.dpc.carrace.util.RandomHelper;

public class Weather {
    private static final int CHANCE_TO_RAIN = 30;

    private static boolean isRaining = false;

    public Weather() {
        randomize();
    }

    public static boolean isRaining() {
        return isRaining;
    }

    public static void randomize() {
        isRaining = RandomHelper.randomizeWithChance(CHANCE_TO_RAIN);
    }
}
