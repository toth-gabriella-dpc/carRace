package com.dpc.carrace.vehicles;

import com.dpc.carrace.Race;

import static com.dpc.carrace.util.RandomHelper.randomizeNumberInRange;

public class Motorcycle extends Vehicle {
    private static int numberOfTheMotorcycle = 1;
    private final int INITIAL_SPEED = 100;
    private final int MIN_REDUCED_SPEED = 5;
    private final int MAX_REDUCED_SPEED = 50;

    public Motorcycle() {
    }

    @Override
    public String setName() {
        return "Motorcycle " + numberOfTheMotorcycle++;
    }

    @Override
    public int setNormalSpeed() {
        return INITIAL_SPEED;
    }

    @Override
    public void prepareForLap(Race race) {
        if (race.isRaining()) {
            setActualSpeed(
                    INITIAL_SPEED - randomizeNumberInRange(MAX_REDUCED_SPEED, MIN_REDUCED_SPEED));
        }

        setActualSpeed(normalSpeed);
    }
}
