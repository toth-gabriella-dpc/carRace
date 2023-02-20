package com.dpc.carrace.vehicles;

import com.dpc.carrace.Race;

import static com.dpc.carrace.util.RandomHelper.randomizeNumberInRange;

public class Motorcycle extends Vehicle {
    private static final int INITIAL_SPEED = 100;
    private static int numberOfTheMotorcycle = 1;
    private final int MIN_REDUCED_SPEED = 5;
    private final int MAX_REDUCED_SPEED = 50;

    public Motorcycle() {
        super(INITIAL_SPEED);
    }

    @Override
    public String setName() {
        return "Motorcycle " + numberOfTheMotorcycle++;
    }

    @Override
    public void prepareForLap(Race race) {
        actualSpeed = normalSpeed;

        if (race.isRaining()) {
            int slowDown = randomizeNumberInRange(MAX_REDUCED_SPEED + 1, MIN_REDUCED_SPEED);
            actualSpeed -= slowDown;
        }

    }
}
