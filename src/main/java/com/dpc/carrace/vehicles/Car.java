package com.dpc.carrace.vehicles;

import com.dpc.carrace.Race;

import java.util.List;

import static com.dpc.carrace.util.RandomHelper.createRandomName;
import static com.dpc.carrace.util.RandomHelper.randomizeNumberInRange;

public class Car extends Vehicle {
    public static final List<String> CAR_NAMES = List.of("Olympian", "Supremacy", "Escape", "Centurion", "Icon", "Thunder", "Thriller", "Behemoth");
    private final int MIN_SPEED = 80;
    private final int MAX_SPEED = 110;
    private final int REDUCED_SPEED = 75;

    @Override
    public String setName() {
        return createRandomName(CAR_NAMES);
    }

    @Override
    public int setNormalSpeed() {
        return randomizeNumberInRange(MAX_SPEED, MIN_SPEED);
    }

    @Override
    public void prepareForLap(Race race) {
        if (race.isYellowFlagActive()) {
            setActualSpeed(REDUCED_SPEED);
        }
        setActualSpeed(normalSpeed);
    }
}
