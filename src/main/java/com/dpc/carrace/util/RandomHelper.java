package com.dpc.carrace.util;

import java.util.List;
import java.util.Random;

public class RandomHelper {
    public final static Random random = new Random();

    public static String chooseOne(List<String> possibilities) {
        if (possibilities == null || possibilities.size() < 1) {
            final String msg = "Possibilities should be a non-empty array of Strings.";
            throw new IllegalStateException(msg);
        }

        return possibilities.get(random.nextInt(possibilities.size()));
    }

    public static int randomizeNumberInRange(int max, int min) {
        return random.nextInt(max - min) + min;
    }

    public static boolean randomizeWithChance(int chance) {
        return random.nextInt(100) < chance;
    }
}
