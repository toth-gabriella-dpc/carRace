package com.dpc.carrace.vehicles;

import com.dpc.carrace.Race;
import com.dpc.carrace.util.RandomHelper;

import java.util.List;

import static com.dpc.carrace.util.RandomHelper.randomizeNumberInRange;

public class Car extends Vehicle {
    public static final List<String> CAR_NAMES = List.of("Olympian", "Supremacy", "Escape", "Centurion", "Icon", "Thunder", "Thriller", "Behemoth");
    private static final int MIN_SPEED = 80;
    private static final int MAX_SPEED = 110;
    private static final int REDUCED_SPEED = 75;

    public Car() {
        super(calculateNormalSpeed());
    }

    public static int calculateNormalSpeed() {
        return randomizeNumberInRange(MAX_SPEED + 1, MIN_SPEED);
    }

    @Override
    public String setName() {
        String firstName = RandomHelper.chooseOne(CAR_NAMES);
        String lastName = RandomHelper.chooseOne(CAR_NAMES);

        return firstName + " " + lastName;
    }

    @Override
    public void prepareForLap(Race race) {
        if (race.isYellowFlagActive()) actualSpeed = REDUCED_SPEED;
        else actualSpeed = normalSpeed;
    }
}
