package com.dpc.carrace.util;

import java.util.List;
import java.util.Random;

public class RandomHelper {
    public final static Random random = new Random();

    public static String createRandomName(List<String> names) {
        String firstName =
                names.get(random.nextInt(names.size()));
        String lastName =
                names.get(random.nextInt(names.size()));

        return firstName + " " + lastName;
    }

    public static int randomizeNumberInRange(int max, int min) {
        return random.nextInt(max - min) + min;
    }

    public static boolean randomizeWithChance(int chance) {
        return random.nextInt(100) < chance;
    }
}
